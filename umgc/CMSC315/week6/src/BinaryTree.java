/**
 * @course CMSC 315
 * @assignment Project 3
 * @description Class BinaryTree: Represents a binary tree with methods for various operations and
 *              checks.
 * @author Adam Langbert
 * @date Sep 20, 2023
 * @java-version Java 17
 */

public class BinaryTree {

    private Node root = null; // Binary tree root node

    static class Node {
        char data;
        Node left, right;

        Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree(String prefixString) throws InvalidTreeSyntax {
        prefixString = validatePrefixString(prefixString);
        StringBuilder str = new StringBuilder(prefixString);
        root = makeTree(str);

        // e.g. "(A(B)(C))a", "(A(B)(C)(1))"
        if (str.length() > 0) {
            throw new InvalidTreeSyntax("Input string contains extra characters or dangling tree");
        }
    }

    // Validates that a given prefixString is formatted correctly
    // Validation that node data is in the right spot is done by makeTree
    private String validatePrefixString(String prefixString) throws InvalidTreeSyntax {
        if (prefixString == null || prefixString.isBlank()) {
            throw new InvalidTreeSyntax("Input string is blank");
        }

        // Remove all whitespace from the input string
        prefixString = prefixString.replaceAll("\\s", "");

        // Check for invalid characters
        if (!prefixString.matches("[()a-zA-Z0-9]*")) {
            throw new InvalidTreeSyntax("Input string contains invalid characters");
        }

        // Check for correctly matched parentheses
        int parenthesesCount = 0;
        for (char c : prefixString.toCharArray()) {
            if (c == '(') {
                parenthesesCount++;
            } else if (c == ')') {
                parenthesesCount--;
            }
            if (parenthesesCount < 0) {
                throw new InvalidTreeSyntax("Input string has mismatched parentheses");
            }
        }
        if (parenthesesCount != 0) {
            throw new InvalidTreeSyntax("Input string has mismatched parentheses");
        }

        return prefixString;
    }

    // Recursively builds a binary tree
    private Node makeTree(StringBuilder str) throws InvalidTreeSyntax {
        // Check for opening parenthesis
        if (str.charAt(0) != '(') {
            throw new InvalidTreeSyntax("Expected '(' at the beginning of a node");
        }
        str.deleteCharAt(0);

        // Check for node data
        if (str.charAt(0) == ')' || str.charAt(0) == '(') {
            throw new InvalidTreeSyntax("Expected node data after '('");
        }

        Node n = new Node(str.charAt(0));
        str.deleteCharAt(0);

        // Check that node data is a single character
        if (str.charAt(0) != ')' && str.charAt(0) != '(') {
            throw new InvalidTreeSyntax("Node data must be a single character");
        }

        // Check for subtrees
        if (str.length() > 0 && str.charAt(0) == '(') {
            n.left = makeTree(str);
        }
        if (str.length() > 0 && str.charAt(0) == '(') {
            n.right = makeTree(str);
        }

        str.deleteCharAt(0);

        return n;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    // A binary tree is balanced if for each node in the tree, the absolute difference between the
    // height of its left and right subtrees is at most 1.
    private boolean isBalanced(Node node) {
        if (node == null)
            return true;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    // A binary tree is full if it has the maximum number of nodes for a tree of its height.
    public boolean isFull() {
        int nodeCount = countNodes(root);
        int height = height(root);
        return nodeCount == Math.pow(2, height + 1) - 1;
    }

    public boolean isProper() {
        return isProper(root);
    }

    // A binary tree is proper if every node has either 0 or 2 children.
    private boolean isProper(Node node) {
        if (node == null)
            return true;

        if ((node.left == null && node.right != null)
                || (node.left != null && node.right == null)) {
            return false;
        }

        return isProper(node.left) && isProper(node.right);
    }


    public int height() {
        return height(root);
    }

    // The height of a binary tree is the maximum level of all of its nodes.
    private int height(Node node) {
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public String inorderTraversal() {
        return inorderTraversal(root);
    }

    private String inorderTraversal(Node node) {
        if (node == null)
            return "";
        return "(" + inorderTraversal(node.left) + node.data + inorderTraversal(node.right) + ")";
    }
}
