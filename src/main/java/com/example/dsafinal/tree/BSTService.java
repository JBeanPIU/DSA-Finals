package com.example.dsafinal.tree;

// imports
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BSTService {
    // builds a BST from a list of integers
    public TreeNode buildBST(List<Integer> numbers) {
        TreeNode root = null;
        for (int number : numbers) {
            root = insert(root, number);
        }
        return root;
    }

    // a helper method that inserts new values into the BST
    private TreeNode insert(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.value) node.left = insert(node.left, value);
        else node.right = insert(node.right, value);
        return node;
    }

    // builds a balanced BST from a list of integers
    public TreeNode buildBalancedBST(List<Integer> numbers) {
        Collections.sort(numbers);
        return buildBalancedHelper(numbers, 0, numbers.size() - 1);
    }

    // another helper method to build a balanced BST
    private TreeNode buildBalancedHelper(List<Integer> numbers, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(numbers.get(mid));
        node.left = buildBalancedHelper(numbers, start, mid - 1);
        node.right = buildBalancedHelper(numbers, mid + 1, end);
        return node;
    }

    // converts a BST into JSON format
    public String treeToJson(TreeNode root) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(root);
    }

    // converts JSON string back into BST format
    public TreeNode jsonToTree(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, TreeNode.class);
    }
}