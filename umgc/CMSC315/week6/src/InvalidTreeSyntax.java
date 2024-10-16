/**
 * @course CMSC 315
 * @assignment Project 3
 * @description Class InvalidTreeSyntax: Represents an exception that is thrown when the syntax of a
 *              binary tree is invalid.
 * @author Adam Langbert
 * @date Sep 20, 2023
 * @java-version Java 17
 */


public class InvalidTreeSyntax extends Exception {
    public InvalidTreeSyntax(String message) {
        super(message);
    }
}
