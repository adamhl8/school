package src;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class Car: Represents a car in the traffic simulation, managing
 *              its position, speed, and visual representation.
 * @java-version Java 17
 */
public class Car extends StackPane {
  private final int carId;
  private final int lane;
  private double position;
  private double speed;
  public static final double CAR_WIDTH = 40;
  public static final double CAR_HEIGHT = 30;

  public Car(int carId, int lane, double initialPosition) {
    this.carId = carId;
    this.lane = lane;
    this.position = initialPosition;
    this.speed = 50;

    Rectangle carBody = new Rectangle(CAR_WIDTH, CAR_HEIGHT, Color.BLUE);
    Text carIdText = new Text(String.valueOf(carId));
    carIdText.setFill(Color.WHITE);

    getChildren().addAll(carBody, carIdText);

    setTranslateX(initialPosition);
    setTranslateY(MainPanel.getLaneYPosition(lane) - CAR_HEIGHT / 2);
  }

  public void updatePosition(double deltaTime) {
    position += speed * deltaTime;
  }

  public int getCarId() {
    return carId;
  }

  public int getLane() {
    return lane;
  }

  public double getPosition() {
    return position;
  }

  public double getSpeed() {
    return speed;
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public void setPosition(double position) {
    this.position = position;
  }
}
