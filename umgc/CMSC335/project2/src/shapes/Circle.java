package src.shapes;

import src.TwoDimensionalShape;

/**
 * @author Adam Langbert
 * @date Nov 12, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Circle: Represents a circle shape with radius and area calculation.
 * @java-version Java 17
 */
public class Circle extends TwoDimensionalShape {
  private double radius;

  public Circle(double radius) {
    super();
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }
}
