import java.util.Comparator;
import java.util.List;

/**
 * Assignment 1: This program creates instances of the Weight class to test its funtionality and its various methods.
 * Also provides methods to find the min, max, and average of a List of weights.
 *
 * Adam Langbert | CMIS 242 | May 28, 2023
 */
public class Project1 {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | CMIS 242 | May 28, 2023 ====\n");

    Weight weight1 = new Weight(11, 3);
    System.out.println(weight1.toString());

    Weight weight2 = new Weight(7, 20);
    System.out.println(weight2.toString());

    Weight weight3 = new Weight(14, 6);
    System.out.println(weight3.toString());

    List<Weight> weightList = List.of(weight1, weight2, weight3);
    findMinimum(weightList);
    findMaximum(weightList);
    findAverage(weightList);

    System.out.printf("weight1 is less than weight2: %s\n", weight1.lessThan(weight2));
    System.out.printf("weight1 is less than weight3: %s\n", weight1.lessThan(weight3));

    weight1.addTo(weight2);
    System.out.println(weight1.toString());
  }

  // Finds and returns the minimum Weight from a List of Weights. Also prints the result.
  private static Weight findMinimum(List<Weight> weights) {
    Weight minWeight = weights
        .stream()
        .min(Comparator.comparing(Weight::getTotalWeightInOunces))
        .orElseThrow();

    System.out.println("The minimum weight is " + minWeight.toString());
    return minWeight;
  }

  // Finds and returns the maximum Weight from a List of Weights. Also prints the result.
  private static Weight findMaximum(List<Weight> weights) {
    Weight maxWeight = weights
        .stream()
        .max(Comparator.comparing(Weight::getTotalWeightInOunces))
        .orElseThrow();

    System.out.println("The maximum weight is " + maxWeight.toString());
    return maxWeight;
  }

  // Returns a new Weight that is the average of a List of Weights. Also prints the result.
  private static Weight findAverage(List<Weight> weights) {
    double average = weights
        .stream()
        .mapToDouble(Weight::getTotalWeightInOunces)
        .average()
        .orElseThrow();
    Weight avgWeight = new Weight(0, average);

    System.out.println("The average weight is " + avgWeight.toString());
    return avgWeight;
  }
}
