package src.polygons.hollow;

import java.awt.*;
import src.polygons.Polygon_;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class HollowPolygon: A hollow polygon that can be drawn on a graphical scene.
 * @java-version Java 17
 */

class HollowPolygon extends Polygon_ {

  // Constructor that calls super constructor

  public HollowPolygon(Color color, int vertexCount) {
    super(color, vertexCount);
  }

  // Draws hollow polygon

  @Override
  public void drawPolygon(Graphics graphics, Polygon polygon) {
    graphics.drawPolygon(polygon);
  }
}
