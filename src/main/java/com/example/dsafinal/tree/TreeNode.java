package com.example.dsafinal.tree;

// imports
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * TreeNode represents a node in the BST. Each of the nodes hold a value and can reference left and right child nodes.
 * i.e:
 */
public class TreeNode {
    public int value; // value stored at this node
    public TreeNode left; // left child node
    public TreeNode right; // right child node

    // a constructor to initialize TreeNode with a value, as left and right nodes are set to null by default
    @JsonCreator
    public TreeNode(@JsonProperty("value") int value) {
        this.value = value;
    }

    // inserts new values into the BST, places new value in correct position based on tree results
    public void insert(int value) {
        // checks if value should go to left subtree (if it doesn't, the value gets sent to the right subtree instead)
        if (value < this.value) {
            // create new left node if there is none there
            if (left == null) {
                left = new TreeNode(value);
            } else {
                // if left node exists, insert value into the left subtree
                left.insert(value);
            }
        } else {
            // if value is greater or equal, sends to right subtree
            if (right == null) {
                right = new TreeNode(value);
            } else {
                right.insert(value);
            }
        }
    }
}

