package src.shapes;

import src.TwoDimensionalShape;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Rectangle: Represents a rectangle shape with length, width, and area
 *              calculation.
 * @java-version Java 17
 */
public class Rectangle extends TwoDimensionalShape {
  private double length;
  private double width;

  public Rectangle(double length, double width) {
    super();
    this.length = length;
    this.width = width;
  }

  @Override
  public double getArea() {
    return length * width;
  }
}
