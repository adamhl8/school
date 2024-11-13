package src.shapes;

import src.TwoDimensionalShape;

/**
 * @author Adam Langbert
 * @date Nov 12, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Triangle: Represents a right triangle shape with base, height, and area
 *              calculation.
 * @java-version Java 17
 */
public class Triangle extends TwoDimensionalShape {
  private double base;
  private double height;

  public Triangle(double base, double height) {
    super();
    this.base = base;
    this.height = height;
  }

  @Override
  public double getArea() {
    return (base * height) / 2;
  }
}
