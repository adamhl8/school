import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

/**
 * @course CMSC 315
 * @assignment Project 3
 * @description Class BinaryTreeGUI: A GUI that allows the user to enter a binary tree in
 *              parenthesized prefix format and perform various operations on it.
 * @author Adam Langbert
 * @date Sep 20, 2023
 * @java-version Java 17
 */

public class BinaryTreeGUI extends JFrame {

    private JTextField inputField;
    private BinaryTree binaryTree;
    private JTextPane outputPane;
    private JButton isBalancedButton, isFullButton, isProperButton, heightButton, countNodesButton,
            inorderTraversalButton;


    // Sets up primary frame and adds components
    public BinaryTreeGUI() {
        setTitle("Binary Tree GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;

        JPanel inputPanel = createInputPanel();
        JPanel buttonPannel = createButtonPanel();
        JTextPane outputField = createOutputField();

        panel.add(inputPanel, c);

        c.gridy = 1;
        panel.add(buttonPannel, c);

        c.insets = new Insets(5, 20, 10, 20);
        c.gridy = 2;
        panel.add(outputField, c);

        // Disable all operation buttons by default
        enableOrDisableOperationButtons(false);

        add(panel);
        pack();
    }

    // Sets up input panel that allows user to input and create binary tree
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;

        JLabel inputLabel = new JLabel("Enter Binary Tree:");
        inputField = new JTextField(20);
        JButton makeTreeButton = createMakeTreeButton(inputField, new Dimension(150, 25));

        panel.add(inputLabel, c);

        c.gridx = 1;
        panel.add(inputField, c);

        c.gridx = 2;
        panel.add(makeTreeButton, c);

        return panel;
    }

    // Creates the binary tree that operations will be performed on.
    private JButton createMakeTreeButton(JTextField inputField, Dimension buttonSize) {
        JButton makeTreeButton = new JButton("Make Tree");
        makeTreeButton.addActionListener(e -> {
            try {
                binaryTree = new BinaryTree(inputField.getText());
                outputPane.setText("Tree created successfully.");
                enableOrDisableOperationButtons(true);
            } catch (InvalidTreeSyntax ex) {
                outputPane.setText("");
                enableOrDisableOperationButtons(false);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Invalid Tree Syntax",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        makeTreeButton.setPreferredSize(buttonSize);
        return makeTreeButton;
    }

    // Panel to hold the various buttons for binary tree operations
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Dimension buttonSize = new Dimension(150, 25);
        c.gridx = 0;
        c.gridy = 0;

        isBalancedButton = createIsBalancedButton(buttonSize);
        isFullButton = createIsFullButton(buttonSize);
        isProperButton = createIsProperButton(buttonSize);
        heightButton = createHeightButton(buttonSize);
        countNodesButton = createCountNodesButton(buttonSize);
        inorderTraversalButton = createInorderTraversalButton(buttonSize);

        buttonPanel.add(isBalancedButton, c);
        c.gridx = 1;
        buttonPanel.add(isFullButton, c);
        c.gridx = 2;
        buttonPanel.add(isProperButton, c);
        c.gridx = 0;
        c.gridy = 1;
        buttonPanel.add(heightButton, c);
        c.gridx = 1;
        buttonPanel.add(countNodesButton, c);
        c.gridx = 2;
        buttonPanel.add(inorderTraversalButton, c);

        return buttonPanel;
    }

    // Binary tree operation buttons

    private JButton createIsBalancedButton(Dimension buttonSize) {
        JButton isBalancedButton = new JButton("Is Balanced?");
        isBalancedButton
                .addActionListener(e -> outputPane.setText(binaryTree.isBalanced() ? "Yes" : "No"));
        isBalancedButton.setPreferredSize(buttonSize);
        return isBalancedButton;
    }

    private JButton createIsFullButton(Dimension buttonSize) {
        JButton isFullButton = new JButton("Is Full?");
        isFullButton.addActionListener(e -> outputPane.setText(binaryTree.isFull() ? "Yes" : "No"));
        isFullButton.setPreferredSize(buttonSize);
        return isFullButton;
    }

    private JButton createIsProperButton(Dimension buttonSize) {
        JButton isProperButton = new JButton("Is Proper?");
        isProperButton
                .addActionListener(e -> outputPane.setText(binaryTree.isProper() ? "Yes" : "No"));
        isProperButton.setPreferredSize(buttonSize);
        return isProperButton;
    }

    private JButton createHeightButton(Dimension buttonSize) {
        JButton heightButton = new JButton("Height");
        heightButton
                .addActionListener(e -> outputPane.setText(String.valueOf(binaryTree.height())));
        heightButton.setPreferredSize(buttonSize);
        return heightButton;
    }

    private JButton createCountNodesButton(Dimension buttonSize) {
        JButton countNodesButton = new JButton("Count Nodes");
        countNodesButton.addActionListener(
                e -> outputPane.setText(String.valueOf(binaryTree.countNodes())));
        countNodesButton.setPreferredSize(buttonSize);
        return countNodesButton;
    }

    private JButton createInorderTraversalButton(Dimension buttonSize) {
        JButton inorderTraversalButton = new JButton("Inorder Traversal");
        inorderTraversalButton
                .addActionListener(e -> outputPane.setText(binaryTree.inorderTraversal()));
        inorderTraversalButton.setPreferredSize(buttonSize);
        return inorderTraversalButton;
    }

    // Enable or disable all binary tree operation buttons.
    private void enableOrDisableOperationButtons(boolean enable) {
        isBalancedButton.setEnabled(enable);
        isFullButton.setEnabled(enable);
        isProperButton.setEnabled(enable);
        heightButton.setEnabled(enable);
        countNodesButton.setEnabled(enable);
        inorderTraversalButton.setEnabled(enable);
    }

    // TextPane for showing output
    private JTextPane createOutputField() {
        outputPane = new JTextPane();
        outputPane.setEditable(false);

        // Centers text in the TextPane
        StyledDocument doc = outputPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        return outputPane;
    }

    public static void main(String[] args) {
        new BinaryTreeGUI().setVisible(true);
    }
}
