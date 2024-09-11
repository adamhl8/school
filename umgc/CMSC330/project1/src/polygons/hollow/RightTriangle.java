package src.polygons.hollow;

import java.awt.*;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class RightTriangle: A right triangle that can be drawn on a graphical scene.
 * @java-version Java 17
 */

public class RightTriangle extends HollowPolygon {

  // Constructor that initializes the vertices of the right triangle

  public RightTriangle(Color color, Point upperLeft, int height, int width) {
    super(color, 3);
    int[] x_points = {upperLeft.x, upperLeft.x, upperLeft.x + width};
    int[] y_points = {upperLeft.y, upperLeft.y + height, upperLeft.y + height};
    createPolygon(x_points, y_points);
  }
}
