package src.polygons.solid;

import java.awt.Color;
import java.awt.Point;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class IsoscelesTriangle: An isosceles triangle that can be drawn on a graphical
 *              scene.
 * @java-version Java 17
 */

public class IsoscelesTriangle extends SolidPolygon {
  public IsoscelesTriangle(Color color, Point topVertex, int height, int width) {
    super(color, 3);
    int[] x_points = {topVertex.x, topVertex.x - width / 2, topVertex.x + width / 2};
    int[] y_points = {topVertex.y, topVertex.y + height, topVertex.y + height};
    createPolygon(x_points, y_points);
  }
}
