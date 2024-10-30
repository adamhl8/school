package src;

import java.util.Scanner;
import src.shapes.Circle;
import src.shapes.Cone;
import src.shapes.Cube;
import src.shapes.Cylinder;
import src.shapes.Rectangle;
import src.shapes.Sphere;
import src.shapes.Square;
import src.shapes.Torus;
import src.shapes.Triangle;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.function.Function;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Main: Entry point of the program, providing command-line interface for shape
 *              calculations.
 * @java-version Java 17
 */
public class Main {

  private static Scanner scanner = new Scanner(System.in);

  // Map to store the menu choices and their corresponding shapes
  private static final Map<String, String> CHOICE_TO_SHAPE = new LinkedHashMap<>() {
    {
      put("1", "Circle");
      put("2", "Rectangle");
      put("3", "Square");
      put("4", "Triangle");
      put("5", "Sphere");
      put("6", "Cube");
      put("7", "Cone");
      put("8", "Cylinder");
      put("9", "Torus");
    }
  };

  // Map to store the shapes and their corresponding dimensions
  private static final Map<String, String[]> SHAPE_TO_DIMENSIONS = new HashMap<>() {
    {
      put("Circle", new String[] {"radius"});
      put("Square", new String[] {"side length"});
      put("Rectangle", new String[] {"length", "width"});
      put("Triangle", new String[] {"base", "height"});
      put("Sphere", new String[] {"radius"});
      put("Cube", new String[] {"side length"});
      put("Cone", new String[] {"radius", "height"});
      put("Cylinder", new String[] {"radius", "height"});
      put("Torus", new String[] {"major radius", "minor radius"});
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

  public static void main(String[] args) {
    System.out.println("Welcome to the Java Shapes Program");

    while (true) {
      System.out.println("\nWhat would you like to construct?");
      String exitChoice = String.valueOf(CHOICE_TO_SHAPE.size() + 1);

      CHOICE_TO_SHAPE.forEach((choice, shape) -> System.out.println(choice + ". " + shape));
      System.out.println(exitChoice + ". Exit\n");

      String choice = scanner.nextLine();

      if (CHOICE_TO_SHAPE.containsKey(choice))
        constructShape(choice);
      else if (choice.equals(exitChoice))
        break;
      else
        System.out
            .println("Invalid option. Please enter a number between 1 and " + exitChoice + ".");
    }

    // Exit message with current date and time
    Date now = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd 'at' h:mm a");
    System.out.println(
        "\nThanks for using the Java Shapes Program. Today is " + formatter.format(now) + ".");
    scanner.close();
  }

  private static void constructShape(String choice) {
    String shapeName = CHOICE_TO_SHAPE.get(choice);

    System.out.println("\nYou selected a " + shapeName);

    // Determine required dimensions based on the shape
    String[] dimensions = SHAPE_TO_DIMENSIONS.get(shapeName);
    double[] dimValues = new double[dimensions.length];
    for (int i = 0; i < dimensions.length; i++) {
      System.out.println("What is the " + dimensions[i] + "?");
      dimValues[i] = getPositiveDouble();
    }

    Shape shape = SHAPE_CONSTRUCTORS.get(shapeName).apply(dimValues);

    // Calculate and display the area or volume
    if (shape instanceof TwoDimensionalShape) {
      System.out.printf("The area of the %s is %.2f.%n", shapeName,
          ((TwoDimensionalShape) shape).getArea());
    } else if (shape instanceof ThreeDimensionalShape) {
      System.out.printf("The volume of the %s is %.2f.%n", shapeName,
          ((ThreeDimensionalShape) shape).getVolume());
    }
  }

  // Utility method to validate positive double input
  private static double getPositiveDouble() {
    while (true) {
      try {
        double value = Double.parseDouble(scanner.nextLine());
        if (value > 0) {
          return value;
        } else {
          System.out.println("Please enter a positive number.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
  }
}
