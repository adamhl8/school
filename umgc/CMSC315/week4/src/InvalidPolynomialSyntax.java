/**
 * @course CMSC 315
 * @assignment Project 2
 * @description Class InvalidPolynomialSyntax: Thrown when the syntax of a polynomial is invalid.
 * @author Adam Langbert
 * @date Sep 10, 2023
 * @java-version Java 17
 */

public class InvalidPolynomialSyntax extends RuntimeException {
    public InvalidPolynomialSyntax(String message) {
        super(("Invalid polynomial syntax. " + message).trim());
    }
}
