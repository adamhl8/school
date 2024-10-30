package src.shapes;

import src.ThreeDimensionalShape;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Sphere: Represents a sphere shape with radius and volume calculation.
 * @java-version Java 17
 */
public class Sphere extends ThreeDimensionalShape {
  private double radius;

  public Sphere(double radius) {
    super();
    this.radius = radius;
  }

  @Override
  public double getVolume() {
    return (4 * Math.PI * Math.pow(radius, 3)) / 3;
  }
}
