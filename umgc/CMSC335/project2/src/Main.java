package src;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import src.shapes.*;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Adam Langbert
 * @date Nov 12, 2024
 * @course CMSC 335
 * @assignment Project 2
 * @description Class Main: Entry point of the program, providing a GUI for shape calculations.
 * @java-version Java 17
 */
public class Main extends Application {

  // Map to store the shapes and their corresponding dimensions
  private static final Map<String, String[]> SHAPE_TO_DIMENSIONS = new HashMap<>() {
    {
      put("Circle", new String[] {"Radius"});
      put("Square", new String[] {"Side Length"});
      put("Rectangle", new String[] {"Length", "Width"});
      put("Triangle", new String[] {"Base", "Height"});
      put("Sphere", new String[] {"Radius"});
      put("Cube", new String[] {"Side Length"});
      put("Cone", new String[] {"Radius", "Height"});
      put("Cylinder", new String[] {"Radius", "Height"});
      put("Torus", new String[] {"Major Radius", "Minor Radius"});
    }
  };

  // Map to store the shapes and their corresponding constructors
  private static final Map<String, Function<double[], Shape>> SHAPE_CONSTRUCTORS = new HashMap<>() {
    {
      put("Circle", values -> new Circle(values[0]));
      put("Square", values -> new Square(values[0]));
      put("Rectangle", values -> new Rectangle(values[0], values[1]));
      put("Triangle", values -> new Triangle(values[0], values[1]));
      put("Sphere", values -> new Sphere(values[0]));
      put("Cube", values -> new Cube(values[0]));
      put("Cone", values -> new Cone(values[0], values[1]));
      put("Cylinder", values -> new Cylinder(values[0], values[1]));
      put("Torus", values -> new Torus(values[0], values[1]));
    }
  };

  private Canvas canvas;

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Java Shapes Program");

    // Main layout
    BorderPane root = new BorderPane();
    root.setPadding(new Insets(10));

    // Top label
    Label welcomeLabel = new Label("Welcome to the Java Shapes Program");
    welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    root.setTop(welcomeLabel);
    BorderPane.setAlignment(welcomeLabel, Pos.CENTER);

    // Left side: Shape selection
    VBox selectionPane = new VBox(15);
    selectionPane.setPadding(new Insets(10));
    selectionPane.setPrefWidth(200);

    Label selectShapeLabel = new Label("Select a Shape:");
    selectShapeLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

    ToggleGroup shapeGroup = new ToggleGroup();

    // 2D Shapes
    VBox twoDShapesBox = new VBox(5);
    Label twoDLabel = new Label("2D Shapes:");
    RadioButton circleButton = new RadioButton("Circle");
    RadioButton rectangleButton = new RadioButton("Rectangle");
    RadioButton squareButton = new RadioButton("Square");
    RadioButton triangleButton = new RadioButton("Triangle");
    circleButton.setToggleGroup(shapeGroup);
    rectangleButton.setToggleGroup(shapeGroup);
    squareButton.setToggleGroup(shapeGroup);
    triangleButton.setToggleGroup(shapeGroup);
    twoDShapesBox.getChildren().addAll(twoDLabel, circleButton, rectangleButton, squareButton,
        triangleButton);

    // 3D Shapes
    VBox threeDShapesBox = new VBox(5);
    Label threeDLabel = new Label("3D Shapes:");
    RadioButton sphereButton = new RadioButton("Sphere");
    RadioButton cubeButton = new RadioButton("Cube");
    RadioButton coneButton = new RadioButton("Cone");
    RadioButton cylinderButton = new RadioButton("Cylinder");
    RadioButton torusButton = new RadioButton("Torus");
    sphereButton.setToggleGroup(shapeGroup);
    cubeButton.setToggleGroup(shapeGroup);
    coneButton.setToggleGroup(shapeGroup);
    cylinderButton.setToggleGroup(shapeGroup);
    torusButton.setToggleGroup(shapeGroup);
    threeDShapesBox.getChildren().addAll(threeDLabel, sphereButton, cubeButton, coneButton,
        cylinderButton, torusButton);

    selectionPane.getChildren().addAll(selectShapeLabel, twoDShapesBox, threeDShapesBox);
    root.setLeft(selectionPane);

    // Center: Input parameters and display area
    VBox inputPane = new VBox(10);
    inputPane.setPadding(new Insets(10));

    Label dimensionsLabel = new Label("Enter Dimensions:");
    dimensionsLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

    GridPane dimensionGrid = new GridPane();
    dimensionGrid.setVgap(10);
    dimensionGrid.setHgap(10);

    TextField[] dimensionFields = new TextField[2]; // Max 2 dimensions
    Label[] dimensionLabels = new Label[2];
    for (int i = 0; i < 2; i++) {
      dimensionLabels[i] = new Label();
      dimensionFields[i] = new TextField();
      dimensionFields[i].setPrefWidth(100);
      dimensionLabels[i].setVisible(false);
      dimensionFields[i].setVisible(false);
      dimensionGrid.add(dimensionLabels[i], 0, i);
      dimensionGrid.add(dimensionFields[i], 1, i);
    }

    Button displayButton = new Button("Display Shape");
    TextArea resultArea = new TextArea();
    resultArea.setPrefRowCount(3);
    resultArea.setWrapText(true);
    resultArea.setEditable(false);

    inputPane.getChildren().addAll(dimensionsLabel, dimensionGrid, displayButton, resultArea);
    root.setCenter(inputPane);

    // Right side: Canvas for drawing shape or displaying image
    canvas = new Canvas(250, 250);
    StackPane canvasPane = new StackPane();
    canvasPane.setStyle("-fx-background-color: white; -fx-background-radius: 10;");
    canvasPane.setPadding(new Insets(10));
    BorderPane.setMargin(canvasPane, new Insets(10));
    canvasPane.getChildren().add(canvas);
    root.setRight(canvasPane);

    // Event handling
    shapeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
      if (shapeGroup.getSelectedToggle() != null) {
        String selectedShape = ((RadioButton) shapeGroup.getSelectedToggle()).getText();
        String[] dims = SHAPE_TO_DIMENSIONS.get(selectedShape);
        for (int i = 0; i < dims.length; i++) {
          dimensionLabels[i].setText(dims[i] + ": ");
          dimensionLabels[i].setVisible(true);
          dimensionFields[i].setVisible(true);
        }
        for (int i = dims.length; i < 2; i++) {
          dimensionLabels[i].setVisible(false);
          dimensionFields[i].setVisible(false);
        }
      }
    });

    displayButton.setOnAction(event -> {
      if (shapeGroup.getSelectedToggle() != null) {
        String selectedShape = ((RadioButton) shapeGroup.getSelectedToggle()).getText();
        try {
          String[] dims = SHAPE_TO_DIMENSIONS.get(selectedShape);
          double[] dimValues = new double[dims.length];
          for (int i = 0; i < dims.length; i++) {
            dimValues[i] = Double.parseDouble(dimensionFields[i].getText());
            if (dimValues[i] <= 0)
              throw new NumberFormatException();
          }
          Shape shape = SHAPE_CONSTRUCTORS.get(selectedShape).apply(dimValues);
          resultArea.clear();
          GraphicsContext gc = canvas.getGraphicsContext2D();
          gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

          if (shape instanceof TwoDimensionalShape) {
            double area = ((TwoDimensionalShape) shape).getArea();
            resultArea.setText(String.format("The area of the %s is %.2f.", selectedShape, area));
            draw2DShape(gc, selectedShape, dimValues);
          } else if (shape instanceof ThreeDimensionalShape) {
            double volume = ((ThreeDimensionalShape) shape).getVolume();
            resultArea
                .setText(String.format("The volume of the %s is %.2f.", selectedShape, volume));
            display3DShapeImage(gc, selectedShape);
          }
        } catch (NumberFormatException e) {
          resultArea.setText("Please enter valid positive numbers for dimensions.");
        }
      } else {
        resultArea.setText("Please select a shape.");
      }
    });

    Scene scene = new Scene(root, 800, 350);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  private void draw2DShape(GraphicsContext gc, String shapeName, double[] dimensions) {
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);

    switch (shapeName) {
      case "Circle":
        double radius = dimensions[0];
        gc.strokeOval((canvas.getWidth() - 2 * radius) / 2, (canvas.getHeight() - 2 * radius) / 2,
            2 * radius, 2 * radius);
        break;
      case "Rectangle":
        double length = dimensions[0];
        double width = dimensions[1];
        gc.strokeRect((canvas.getWidth() - length) / 2, (canvas.getHeight() - width) / 2, length,
            width);
        break;
      case "Square":
        double side = dimensions[0];
        gc.strokeRect((canvas.getWidth() - side) / 2, (canvas.getHeight() - side) / 2, side, side);
        break;
      case "Triangle":
        double base = dimensions[0];
        double height = dimensions[1];
        gc.strokePolygon(
            new double[] {canvas.getWidth() / 2 - base / 2, canvas.getWidth() / 2 + base / 2,
                canvas.getWidth() / 2},
            new double[] {canvas.getHeight() / 2 + height / 2, canvas.getHeight() / 2 + height / 2,
                canvas.getHeight() / 2 - height / 2},
            3);
        break;
      default:
        break;
    }
  }

  private void display3DShapeImage(GraphicsContext gc, String shapeName) {
    try {
      String imageName = shapeName.toLowerCase() + ".png";
      Image image = new Image(getClass().getResourceAsStream("/images/" + imageName));
      gc.drawImage(image, (canvas.getWidth() - image.getWidth()) / 2,
          (canvas.getHeight() - image.getHeight()) / 2);
    } catch (Exception e) {
      gc.setFill(Color.RED);
      gc.fillText("Image not found for " + shapeName, 10, 50);
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
