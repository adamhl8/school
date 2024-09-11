package src.parser;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class LexicalError: Exception class that defines a lexical error.
 * @java-version Java 17
 */

public class LexicalError extends Exception {
  // Constructor that creates a lexical error object given the line number and error

  public LexicalError(int line, String description) {
    super("Lexical Error on Line: " + line + " " + description);
  }
}
