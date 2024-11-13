package src;

/**
 * @author Adam Langbert
 * @date Nov 12, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Shape: Abstract base class for all shapes, defining common properties.
 * @java-version Java 17
 */
public abstract class Shape {
  private int numberOfDimensions;

  public Shape(int numberOfDimensions) {
    this.numberOfDimensions = numberOfDimensions;
  }

  public int getNumberOfDimensions() {
    return numberOfDimensions;
  }
}
