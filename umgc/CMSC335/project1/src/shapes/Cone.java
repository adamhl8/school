package src.shapes;

import src.ThreeDimensionalShape;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Cone: Represents a cone shape with radius, height, and volume calculation.
 * @java-version Java 17
 */
public class Cone extends ThreeDimensionalShape {
  private double radius;
  private double height;

  public Cone(double radius, double height) {
    super();
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double getVolume() {
    return (Math.PI * Math.pow(radius, 2) * height) / 3;
  }
}
