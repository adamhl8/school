package src;

/**
 * @author Adam Langbert
 * @date Nov 12, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class ThreeDimensionalShape: Abstract base class for all 3D shapes, providing volume
 *              calculation.
 * @java-version Java 17
 */
public abstract class ThreeDimensionalShape extends Shape {

  public ThreeDimensionalShape() {
    super(3);
  }

  public abstract double getVolume();
}
