package src;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class MainPanel: The is the main display panel which shows the
 *              road, cars, and traffic lights.
 * @java-version Java 17
 */
public class MainPanel extends Pane {
  private final Canvas canvas;
  private final List<TrafficLight> trafficLights;
  private final List<Car> cars;
  public static final double ROAD_HEIGHT = 300;
  public static final double LANE_HEIGHT = 40;
  public static final double ROAD_LENGTH = 1000;

  public MainPanel() {
    canvas = new Canvas(1000, 400);
    trafficLights = new ArrayList<>();
    cars = new ArrayList<>();

    getChildren().add(canvas);
    drawRoad();
  }

  public static double getLaneYPosition(int lane) {
    double laneCenter = ROAD_HEIGHT - (3 * LANE_HEIGHT) + (lane - 0.5) * LANE_HEIGHT;
    return laneCenter;
  }

  public void drawRoad() {
    GraphicsContext gc = canvas.getGraphicsContext2D();

    // Draw road background
    double roadTop = ROAD_HEIGHT - (LANE_HEIGHT * 3);
    gc.setFill(Color.DARKGRAY);
    gc.fillRect(0, roadTop, ROAD_LENGTH, LANE_HEIGHT * 3);

    // Draw lane markings
    gc.setStroke(Color.WHITE);
    gc.setLineDashes(10);

    // Draw lines between lanes (not including top and bottom edges)
    for (int lane = 1; lane < 3; lane++) {
      double y = ROAD_HEIGHT - (3 * LANE_HEIGHT) + (lane * LANE_HEIGHT);
      gc.strokeLine(0, y, ROAD_LENGTH, y);
    }
  }

  public void addTrafficLight(TrafficLight light) {
    trafficLights.add(light);
    getChildren().add(light);
  }

  public void addCar(Car car) {
    cars.add(car);
    getChildren().add(car);
  }

  public List<TrafficLight> getTrafficLights() {
    return trafficLights;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void removeCar(Car car) {
    cars.remove(car);
    getChildren().remove(car);
  }
}
