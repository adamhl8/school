package src;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Adam Langbert
 * @date Dec 9, 2024
 * @course CMSC 335
 * @assignment Project 3
 * @description Class DurationPanel: Displays and tracks the elapsed time of the
 *              simulation.
 * @java-version Java 17
 */
public class DurationPanel extends VBox {
  private final Label durationLabel;
  private LocalDateTime startTime;
  private Duration pausedDuration;
  private boolean isFirstStart;

  public DurationPanel() {
    this.pausedDuration = Duration.ZERO;
    this.isFirstStart = true;
    this.durationLabel = new Label("Duration: 00:00:00");
    durationLabel.setStyle("-fx-font-size: 16px; -fx-padding: 10px;");
    getChildren().add(durationLabel);
  }

  public void startTiming() {
    if (isFirstStart) {
      this.startTime = LocalDateTime.now();
      isFirstStart = false;
    } else {
      // When resuming, adjust startTime to account for the elapsed time before pause
      this.startTime = LocalDateTime.now().minus(pausedDuration);
    }
  }

  public void pauseTiming() {
    // Store the current duration when pausing
    pausedDuration = Duration.between(startTime, LocalDateTime.now());
  }

  public void updateDuration() {
    if (startTime != null) {
      Duration duration = Duration.between(startTime, LocalDateTime.now());
      long hours = duration.toHours();
      long minutes = duration.toMinutesPart();
      long seconds = duration.toSecondsPart();
      durationLabel.setText(String.format("Duration: %02d:%02d:%02d", hours, minutes, seconds));
    }
  }
}
