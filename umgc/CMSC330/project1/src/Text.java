package src;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class Text: Represents a text object that can be drawn on a graphical scene.
 * @java-version Java 17
 */

public class Text extends Image {
  private String text;
  private Point location;

  public Text(Color color, Point location, String text) {
    super(color);
    this.location = location;
    this.text = text;
  }

  @Override
  public void draw(Graphics graphics) {
    colorDrawing(graphics);
    graphics.drawString(text, location.x, location.y);
  }
}
