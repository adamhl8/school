package src;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class ControlPanel: Contains control buttons for managing the
 *              traffic simulation, including adding cars and lights, and
 *              starting/stopping the simulation.
 * @java-version Java 17
 */
public class ControlPanel extends HBox {
  private final Button addCarButton;
  private final Button addLightButton;
  private final Button startButton;
  private final Button stopButton;

  public ControlPanel() {
    setStyle("-fx-padding: 10px; -fx-spacing: 10px; -fx-background-color: #e0e0e0;");
    setPadding(new Insets(10));

    addCarButton = new Button("Add Car");
    addLightButton = new Button("Add Light");
    startButton = new Button("Start");
    stopButton = new Button("Stop");

    String buttonStyle = "-fx-font-size: 14px; -fx-min-width: 80px;";
    addCarButton.setStyle(buttonStyle);
    addLightButton.setStyle(buttonStyle);
    startButton.setStyle(buttonStyle);
    stopButton.setStyle(buttonStyle);

    stopButton.setDisable(true);

    getChildren().addAll(startButton, stopButton, addCarButton, addLightButton);
  }

  public Button getAddCarButton() {
    return addCarButton;
  }

  public Button getAddLightButton() {
    return addLightButton;
  }

  public Button getStartButton() {
    return startButton;
  }

  public Button getStopButton() {
    return stopButton;
  }
}
