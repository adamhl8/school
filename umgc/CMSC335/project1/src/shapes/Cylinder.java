package src.shapes;

import src.ThreeDimensionalShape;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Cylinder: Represents a cylinder shape with radius, height, and volume
 *              calculation.
 * @java-version Java 17
 */
public class Cylinder extends ThreeDimensionalShape {
  private double radius;
  private double height;

  public Cylinder(double radius, double height) {
    super();
    this.radius = radius;
    this.height = height;
  }

  @Override
  public double getVolume() {
    return Math.PI * Math.pow(radius, 2) * height;
  }
}
