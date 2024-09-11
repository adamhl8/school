package src.parser;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class SyntaxError: Exception class that defines a syntax error.
 * @java-version Java 17
 */

public class SyntaxError extends Exception {
  // Constructor that creates a syntax error object given the line number and error

  public SyntaxError(int line, String description) {
    super("Syntax Error on Line: " + line + " " + description);
  }
}
