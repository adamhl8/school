package src;

import javafx.application.Platform;
import javafx.animation.AnimationTimer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class SimulationController: Controls the traffic simulation,
 *              managing cars, traffic lights, and animation updates.
 * @java-version Java 17
 */
public class SimulationController {
  private final MainPanel mainPanel;
  private final DurationPanel durationPanel;
  private final CarInfoPanel carInfoPanel;
  private final ControlPanel controlPanel;
  private ExecutorService executorService;
  private volatile boolean isRunning;
  private AnimationTimer animationLoop;
  private List<Thread> lightThreads;
  private long lastUpdateTime;

  public SimulationController(MainPanel mainPanel, DurationPanel durationPanel,
      CarInfoPanel carInfoPanel, ControlPanel controlPanel) {
    this.mainPanel = mainPanel;
    this.durationPanel = durationPanel;
    this.carInfoPanel = carInfoPanel;
    this.controlPanel = controlPanel;
    this.executorService = Executors.newCachedThreadPool();
    this.lightThreads = new ArrayList<>();
    this.isRunning = false;

    setupControlButtons();
    setupAnimationLoop();
  }

  private void setupControlButtons() {
    controlPanel.getStartButton().setOnAction(e -> {
      isRunning = true;
      lastUpdateTime = System.nanoTime();
      animationLoop.start();

      // Restart traffic lights
      for (TrafficLight light : mainPanel.getTrafficLights()) {
        startLightCycle(light);
      }

      // Restart duration display thread
      executorService = Executors.newCachedThreadPool();
      durationPanel.startTiming();
      startDurationThread();

      controlPanel.getStartButton().setDisable(true);
      controlPanel.getStopButton().setDisable(false);
    });

    controlPanel.getStopButton().setOnAction(e -> {
      isRunning = false;
      animationLoop.stop();
      durationPanel.pauseTiming();
      for (Thread thread : lightThreads) {
        thread.interrupt();
      }
      lightThreads.clear();
      controlPanel.getStartButton().setDisable(false);
      controlPanel.getStopButton().setDisable(true);
    });

    controlPanel.getAddCarButton().setOnAction(e -> {
      if (mainPanel.getCars().size() < 3) {
        addNewCar();
      }
    });

    controlPanel.getAddLightButton().setOnAction(e -> {
      if (mainPanel.getTrafficLights().size() < 6) {
        addNewTrafficLight();
      }
    });
  }

  private void setupAnimationLoop() {
    animationLoop = new AnimationTimer() {
      @Override
      public void handle(long now) {
        if (lastUpdateTime == 0) {
          lastUpdateTime = now;
          return;
        }

        double deltaTime = (now - lastUpdateTime) / 1_000_000_000.0;
        if (isRunning) {
          updateSimulation(deltaTime);
        }
        lastUpdateTime = now;
      }
    };
  }

  private void updateSimulation(double deltaTime) {
    for (Car car : mainPanel.getCars()) {
      // Update car position
      double oldPosition = car.getPosition();
      car.updatePosition(deltaTime);

      // Check for traffic lights
      boolean isStoppedAtLight = false;
      for (TrafficLight light : mainPanel.getTrafficLights()) {
        double carFront = car.getPosition();
        double stopPosition = light.getPosition() - Car.CAR_WIDTH - 1;

        // If car is at this light
        if (Math.abs(carFront - stopPosition) < 1) {
          if (light.getState() == TrafficLight.LightState.RED) {
            car.setPosition(stopPosition);
            car.setSpeed(0);
            isStoppedAtLight = true;
          } else {
            // Light is green or yellow, resume moving
            car.setSpeed(50);
          }
        }
        // If car is approaching a red light
        else if (oldPosition < light.getPosition() && carFront >= light.getPosition()) {
          if (light.getState() == TrafficLight.LightState.RED
              && oldPosition < light.getPosition()) {
            car.setPosition(stopPosition);
            car.setSpeed(0);
            isStoppedAtLight = true;
          }
        }
      }

      // If car isn't stopped at any light and has zero speed, resume moving
      if (!isStoppedAtLight && car.getSpeed() == 0) {
        car.setSpeed(50);
      }

      // Update car visual position
      car.setTranslateX(car.getPosition());
      car.setTranslateY(MainPanel.getLaneYPosition(car.getLane()) - Car.CAR_HEIGHT / 2);

      carInfoPanel.updateCarInfo(car.getCarId(), car.getSpeed(), car.getPosition());

      // Remove car if it reaches the end
      if (car.getPosition() >= MainPanel.ROAD_LENGTH) {
        Platform.runLater(() -> {
          mainPanel.removeCar(car);
          controlPanel.getAddCarButton().setDisable(false);
        });
      }
    }
  }

  private void addNewCar() {
    int nextId = carInfoPanel.getNextCarId();

    // Find first available lane
    boolean[] lanesOccupied = new boolean[3];
    for (Car car : mainPanel.getCars()) {
      lanesOccupied[car.getLane() - 1] = true;
    }

    int lane = 0;
    for (int i = 0; i < lanesOccupied.length; i++) {
      if (!lanesOccupied[i]) {
        lane = i + 1;
        break;
      }
    }

    if (lane > 0) {
      Car car = new Car(nextId, lane, 0);

      mainPanel.addCar(car);

      if (mainPanel.getCars().size() >= 3) {
        controlPanel.getAddCarButton().setDisable(true);
      }
    }
  }

  private void addNewTrafficLight() {
    int lightCount = mainPanel.getTrafficLights().size();
    double spacing = MainPanel.ROAD_LENGTH / (6.0 + 1);
    double position = spacing * (lightCount + 1);

    TrafficLight light = new TrafficLight(position);
    light.setTranslateX(position);
    light.setTranslateY(MainPanel.ROAD_HEIGHT - (MainPanel.LANE_HEIGHT * 3) - TrafficLight.LIGHT_HEIGHT);

    mainPanel.addTrafficLight(light);
    startLightCycle(light);

    if (mainPanel.getTrafficLights().size() >= 6) {
      controlPanel.getAddLightButton().setDisable(true);
    }
  }

  private void startLightCycle(TrafficLight light) {
    Thread lightThread = new Thread(() -> {
      while (!Thread.interrupted() && isRunning) {
        try {
          light.setState(TrafficLight.LightState.RED);
          Thread.sleep(5000);
          if (!isRunning)
            break;

          light.setState(TrafficLight.LightState.GREEN);
          Thread.sleep(5000);
          if (!isRunning)
            break;

          light.setState(TrafficLight.LightState.YELLOW);
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          break;
        }
      }
    });
    lightThreads.add(lightThread);
    lightThread.start();
  }

  private void startDurationThread() {
    executorService.submit(() -> {
      while (isRunning) {
        Platform.runLater(() -> durationPanel.updateDuration());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
    });
  }

  public void startSimulation() {
    isRunning = false;
    controlPanel.getStartButton().setDisable(false);
    controlPanel.getStopButton().setDisable(true);
  }

  public void stopSimulation() {
    isRunning = false;
    for (Thread thread : lightThreads) {
      thread.interrupt();
    }
    lightThreads.clear();

    if (animationLoop != null) {
      animationLoop.stop();
    }
    executorService.shutdownNow();
  }
}
