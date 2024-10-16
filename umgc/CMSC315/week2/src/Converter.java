import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @course CMSC 315
 * @assignment Project 1
 * @description Class Converter: Converts prefix and postfix expressions to each other using stacks.
 * @author Adam Langbert
 * @date Aug 28, 2023
 * @java-version Java 17
 */

public class Converter {

  private Converter() {}

  private enum ConversionType {
    PREFIX_TO_POSTFIX, POSTFIX_TO_PREFIX
  }

  public static String prefixToPostfix(String expression) throws SyntaxError {
    return convert(expression, ConversionType.PREFIX_TO_POSTFIX);
  }

  public static String postfixToPrefix(String expression) throws SyntaxError {
    return convert(expression, ConversionType.POSTFIX_TO_PREFIX);
  }

  private static String convert(String expression, ConversionType conversionType)
      throws SyntaxError {
    Stack<String> operandStack = new Stack<>();

    List<String> tokens = tokenize(expression);
    // When converting from prefix to postfix, read tokens in reverse order
    if (conversionType == ConversionType.PREFIX_TO_POSTFIX) {
      Collections.reverse(tokens);
    }

    for (String token : tokens) {
      if (Character.isDigit(token.charAt(0))) {
        operandStack.push(token);
      } else {
        if (operandStack.size() < 2)
          throw new SyntaxError("Not enough operands for operator: " + token);
        String operand1 = operandStack.pop();
        String operand2 = operandStack.pop();
        switch (conversionType) {
          case PREFIX_TO_POSTFIX -> operandStack.push(operand1 + " " + operand2 + " " + token);
          case POSTFIX_TO_PREFIX -> operandStack.push(token + " " + operand2 + " " + operand1);
        }
      }
    }

    if (operandStack.size() != 1)
      throw new SyntaxError("Extraneous input or missing operator(s)");
    return operandStack.pop();
  }

  private static List<String> tokenize(String expression) throws SyntaxError {
    List<String> tokens = new ArrayList<>();
    StringBuilder number = new StringBuilder();

    Set<Character> operators = Set.of('+', '-', '*', '/');

    for (char ch : expression.toCharArray()) {
      if (Character.isDigit(ch)) {
        number.append(ch);
      } else {
        // If not a digit, we know we've reached the end of a number and can add it to the list
        if (number.length() > 0) {
          tokens.add(number.toString());
          number.setLength(0); // Reset the StringBuilder
        }

        if (operators.contains(ch)) {
          tokens.add(String.valueOf(ch));
        } else if (Character.isWhitespace(ch)) {
          // Ignore/remove whitespace
        } else {
          throw new SyntaxError("Invalid operator: " + ch);
        }
      }
    }

    // Add the last number if present
    if (number.length() > 0) {
      tokens.add(number.toString());
    }

    return tokens;
  }
}
