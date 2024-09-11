package src;

import javax.swing.*;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class Scene: Represents a graphical scene with a window and drawing panel. It allows
 *              adding images to the scene and drawing them on the panel.
 * @java-version Java 17
 */

public class Scene {

  private JFrame window;
  private DrawingPanel drawing;

  // Constructor that must be supplied the height and width of the drawing window for the scene

  public Scene(String name, int height, int width) {
    window = new JFrame(name);
    window.setSize(width, height);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    drawing = new DrawingPanel();
    window.add(drawing);
  }

  // Adds a graphic object to the scene's drawing panel

  public void addImage(Image image) {
    drawing.addImage(image);
  }

  // Causes the drawing panel to be repainted

  public void draw() {
    window.setVisible(true);
    drawing.repaint();
  }
}
