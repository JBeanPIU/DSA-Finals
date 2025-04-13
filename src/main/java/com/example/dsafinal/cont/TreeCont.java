package com.example.dsafinal.cont;

// imports
import com.example.dsafinal.model.TreeEntity;
import com.example.dsafinal.repo.TreeRepo;
import com.example.dsafinal.tree.*;
import com.example.dsafinal.tree.TreeNode;
import com.fasterxml.jackson.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.*;


/**
 * The TreeCont class is used to handle all routing and HTTP processing for the HTML page. It
 * is also the main class used to allow user input, input to BST conversion, and past-tree viewing.
 * Each of the routes scheming have been kept short (nums as opposed to numbers) to differentiate
 * the HTML templates and the back-end logic since back-end uses full naming.
 */
@Controller
public class TreeCont {

    @Autowired
    private BSTService bstService; // this is used to build and convert BSTs

    @Autowired
    private TreeRepo treeRepo; // JPA repo to save/retrieve objects from TreeEntity in /model

    // GET route showing form
    @GetMapping("/enter-nums") // nums = numbers for short
    public String showForm() {
        return "enter-nums"; // directs you to the HTML template
    }

    // POST route for number processing (this section serializes the numbers and puts it into BST format)
    @PostMapping("/process-nums")
    public String processNums(@RequestParam("nums") String numInput, Model model) throws JsonProcessingException {
        // converts the input string into a list of integers
        List<Integer> nums = Arrays.stream(numInput.trim().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // generate balanced BST / converts tree to JSON string for display
        TreeNode root = bstService.buildBalancedBST(nums); // alternatively, .buildBST for unbalanced
        String treeJson = bstService.treeToJson(root);

        // save to db
        TreeEntity treeEntity = new TreeEntity();
        treeEntity.setInputNums(numInput);
        treeEntity.setTreeJson(treeJson);
        treeRepo.save(treeEntity);

        // after everything, passes tree JSON through to be viewable
        model.addAttribute("treeJson", treeJson);
        return "tree-result";
    }

    // GET route to display a list of all previously submitted trees
    @GetMapping("/prev-trees")
    public String showPreviousTrees(Model model) {
        List<TreeEntity> allTrees = treeRepo.findAll();
        model.addAttribute("trees", allTrees);
        return "prev-trees";
    }
}
