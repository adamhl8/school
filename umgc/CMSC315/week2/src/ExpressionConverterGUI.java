import javax.swing.*;
import java.awt.*;

/**
 * @course CMSC 315
 * @assignment Project 1
 * @description Class Main: A GUI that allows the user to convert expressions between prefix and
 *              postfix notation.
 * @author Adam Langbert
 * @date Aug 28, 2023
 * @java-version Java 17
 */

// Allows for passing a Converter method to another method
// See ExpressionConverterGUI::performConversion
@FunctionalInterface
interface ConversionFunction {
  String apply(String s) throws SyntaxError;
}


public class ExpressionConverterGUI extends JPanel {
  JLabel inputLabel;
  JTextField inputTextField;
  JButton toPostfixButton;
  JButton toPrefixButton;
  JLabel outputLabel;
  JTextField outputTextField;

  public ExpressionConverterGUI() {
    inputLabel = new JLabel("Enter expression:");
    inputTextField = new JTextField(20);
    toPostfixButton = new JButton("to Postfix");
    toPrefixButton = new JButton("to Prefix");
    outputLabel = new JLabel("Result:");
    outputTextField = new JTextField(20);

    toPostfixButton.addActionListener(e -> performConversion(Converter::prefixToPostfix));
    toPrefixButton.addActionListener(e -> performConversion(Converter::postfixToPrefix));

    layoutGUI();
  }

  // Performs the conversion using the passed ConversionFunction
  private void performConversion(ConversionFunction conversionFunction) {
    String input = inputTextField.getText();

    if (input.isBlank()) {
      displayError("Please enter an expression.");
      return;
    }

    try {
      String result = conversionFunction.apply(input);
      outputTextField.setText(result);
    } catch (SyntaxError syntaxError) {
      displayError(syntaxError.getMessage());
    }
  }

  private void displayError(String message) {
    JOptionPane.showMessageDialog(this, message, "Syntax Error", JOptionPane.ERROR_MESSAGE);
  }

  private void layoutGUI() {
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 5, 0, 5);
    c.gridx = 0;
    c.gridy = 0;
    add(inputLabel, c);

    c.insets = new Insets(0, 5, 0, 5);
    c.gridy++;
    add(inputTextField, c);

    c.insets = new Insets(10, 5, 0, 5);
    c.gridy++;
    add(toPostfixButton, c);

    c.insets = new Insets(0, 5, 0, 5);
    c.gridy++;
    add(toPrefixButton, c);

    c.insets = new Insets(10, 5, 0, 5);
    c.gridy++;
    add(outputLabel, c);

    c.insets = new Insets(0, 5, 10, 5);
    c.gridy++;
    add(outputTextField, c);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Expression Converter");
    JPanel panel = new ExpressionConverterGUI();
    frame.setContentPane(panel);
    panel.setOpaque(true);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
