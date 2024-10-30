package src.shapes;

import src.TwoDimensionalShape;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Square: Represents a square shape with side length and area calculation.
 * @java-version Java 17
 */
public class Square extends TwoDimensionalShape {
  private double side;

  public Square(double side) {
    super();
    this.side = side;
  }

  @Override
  public double getArea() {
    return side * side;
  }
}
