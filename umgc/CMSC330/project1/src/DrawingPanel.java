package src;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class DrawingPanel: A JPanel that allows for adding images to the drawing panel.
 * @java-version Java 17
 */

class DrawingPanel extends JPanel {

  private ArrayList<Image> images = new ArrayList<>();

  // Adds a graphic object to the drawing panel

  public void addImage(Image image) {

    images.add(image);
  }

  // Draws all the images on the drawing panel

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    for (Image image : images)
      image.draw(graphics);
  }
}
