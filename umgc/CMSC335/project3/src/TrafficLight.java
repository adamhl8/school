package src;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class TrafficLight: Represents a traffic light in the
 *              simulation, managing its state and visual appearance.
 * @java-version Java 17
 */
public class TrafficLight extends StackPane {
  public static final double LIGHT_HEIGHT = 30;

  private final Circle light;
  private final Rectangle box;
  private LightState state;
  private final double position;

  public enum LightState {
    RED(Color.RED), YELLOW(Color.YELLOW), GREEN(Color.GREEN);

    private final Color color;

    LightState(Color color) {
      this.color = color;
    }

    public Color getColor() {
      return color;
    }
  }

  public TrafficLight(double position) {
    this.position = position;
    box = new Rectangle(30, LIGHT_HEIGHT, Color.DARKGRAY);
    light = new Circle(10, Color.RED);
    state = LightState.RED;

    getChildren().addAll(box, light);
  }

  public void setState(LightState newState) {
    this.state = newState;
    light.setFill(newState.getColor());
  }

  public LightState getState() {
    return state;
  }

  public double getPosition() {
    return position;
  }
}
