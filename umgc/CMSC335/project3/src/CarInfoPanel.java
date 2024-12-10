package src;

import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.application.Platform;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class CarInfoPanel: Displays information about cars in the
 *              simulation, including their speed and distance.
 * @java-version Java 17
 */
public class CarInfoPanel extends VBox {
  private final ListView<String> carInfoList;
  private int carCounter = 0;

  public CarInfoPanel() {
    setStyle("-fx-padding: 10px; -fx-spacing: 5px; -fx-background-color: #f0f0f0;");
    setPrefWidth(250);

    Label titleLabel = new Label("Car Information");
    titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 0 0 10px 0;");

    carInfoList = new ListView<>();
    carInfoList.setPrefWidth(USE_COMPUTED_SIZE);
    carInfoList.setStyle("-fx-font-family: monospace;");

    getChildren().addAll(titleLabel, carInfoList);
  }

  public void updateCarInfo(int carId, double speed, double distance) {
    Platform.runLater(() -> {
      carInfoList.getItems().removeIf(info -> info.startsWith("Car " + carId));

      String info = String.format("Car %d%n  Speed: %.1f m/s%n  Distance: %.1f m", carId, speed, distance);
      carInfoList.getItems().add(0, info);
    });
  }

  public int getNextCarId() {
    return ++carCounter;
  }
}
