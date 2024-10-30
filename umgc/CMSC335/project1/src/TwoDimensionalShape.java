package src;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class TwoDimensionalShape: Abstract base class for all 2D shapes, providing area
 *              calculation.
 * @java-version Java 17
 */
public abstract class TwoDimensionalShape extends Shape {

  public TwoDimensionalShape() {
    super(2);
  }

  public abstract double getArea();
}
