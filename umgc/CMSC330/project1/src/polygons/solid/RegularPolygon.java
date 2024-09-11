package src.polygons.solid;

import java.awt.Color;
import java.awt.Point;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class RegularPolygon: A regular polygon that can be drawn on a graphical scene.
 * @java-version Java 17
 */

public class RegularPolygon extends SolidPolygon {
  public RegularPolygon(Color color, Point center, int sides, int radius) {
    super(color, sides);
    int[] x_points = new int[sides];
    int[] y_points = new int[sides];
    for (int i = 0; i < sides; i++) {
      double angle = 2 * Math.PI * i / sides;
      x_points[i] = (int) (center.x + radius * Math.cos(angle));
      y_points[i] = (int) (center.y + radius * Math.sin(angle));
    }
    createPolygon(x_points, y_points);
  }
}
