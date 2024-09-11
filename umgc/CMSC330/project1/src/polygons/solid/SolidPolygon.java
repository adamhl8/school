package src.polygons.solid;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;
import src.polygons.Polygon_;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class SolidPolygon: A solid polygon that can be drawn on a graphical scene.
 * @java-version Java 17
 */

class SolidPolygon extends Polygon_ {
  public SolidPolygon(Color color, int vertexCount) {
    super(color, vertexCount);
  }

  @Override
  public void drawPolygon(Graphics graphics, Polygon polygon) {
    graphics.fillPolygon(polygon);
  }
}
