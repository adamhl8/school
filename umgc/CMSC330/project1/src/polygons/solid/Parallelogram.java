package src.polygons.solid;

import java.awt.Color;
import java.awt.Point;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class Parallelogram: A parallelogram that can be drawn on a graphical scene.
 * @java-version Java 17
 */

public class Parallelogram extends SolidPolygon {
  public Parallelogram(Color color, Point upperLeft, Point lowerRight, int x_offset) {
    super(color, 4);
    int[] x_points = {upperLeft.x, lowerRight.x + x_offset, lowerRight.x, upperLeft.x - x_offset};
    int[] y_points = {upperLeft.y, upperLeft.y, lowerRight.y, lowerRight.y};
    createPolygon(x_points, y_points);
  }
}
