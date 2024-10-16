/**
 * @course CMSC 315
 * @assignment Project 1
 * @description Class SyntaxError: An exception class for syntax errors in expression conversion.
 * @author Adam Langbert
 * @date Aug 28, 2023
 * @java-version Java 17
 */

public class SyntaxError extends Exception {
  public SyntaxError(String message) {
    super(message);
  }
}
