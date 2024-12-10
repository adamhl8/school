package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class Main: Entry point of the program, providing a GUI for
 *              the simulation.
 * @java-version Java 17
 */
public class Main extends Application {
  private SimulationController simulationController;
  private static final int WINDOW_WIDTH = 1300;
  private static final int WINDOW_HEIGHT = 800;

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();

    MainPanel mainPanel = new MainPanel();
    DurationPanel durationPanel = new DurationPanel();
    CarInfoPanel carInfoPanel = new CarInfoPanel();
    ControlPanel controlPanel = new ControlPanel();

    simulationController = new SimulationController(mainPanel, durationPanel, carInfoPanel, controlPanel);

    root.setTop(durationPanel);
    root.setCenter(mainPanel);
    root.setRight(carInfoPanel);
    root.setBottom(controlPanel);

    Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
    primaryStage.setTitle("Traffic Simulation");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();

    simulationController.startSimulation();
  }

  @Override
  public void stop() {
    if (simulationController != null) {
      simulationController.stopSimulation();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
