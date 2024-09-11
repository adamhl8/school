package src;

import java.awt.*;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class Image: Abstract base class that defines all image objects.
 * @java-version Java 17
 */

public abstract class Image {

  private Color color;

  // Constructor that can only be called by the subclasses to initialize the color

  public Image(Color color) {
    this.color = color;
  }

  // Sets the color of the image to be drawn. Must be called first by the draw function of the
  // subclasses

  public void colorDrawing(Graphics graphics) {
    graphics.setColor(color);
  }

  public abstract void draw(Graphics graphics);
}
