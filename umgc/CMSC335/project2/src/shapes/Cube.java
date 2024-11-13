package src.shapes;

import src.ThreeDimensionalShape;

/**
 * @author Adam Langbert
 * @date Nov 12, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Cube: Represents a cube shape with side length and volume calculation.
 * @java-version Java 17
 */
public class Cube extends ThreeDimensionalShape {
  private double side;

  public Cube(double side) {
    super();
    this.side = side;
  }

  @Override
  public double getVolume() {
    return Math.pow(side, 3);
  }
}
