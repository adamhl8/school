/**
 * @course CMSC 315
 * @assignment Week 1 Discussion
 * @description Class GrowthComparison: Shows the different growth rates of two functions.
 * @author Adam Langbert
 * @date Aug 17, 2023
 * @java-version Java 17
 */

public class GrowthComparison {
  public static void main(String[] args) {
    int n = 1;

    System.out.println("n\tf(n)\tg(n)");

    while (g(n) <= f(n)) {
      System.out.println(n + "\t" + f(n) + "\t" + g(n));
      n++;
    }

    System.out.println(n + "\t" + f(n) + "\t" + g(n));
    System.out.println("At n = " + n + ", g(n) " + "surpasses f(n)");
  }

  // Linear function: f(n) = 25n
  private static int f(int n) {
    return 25 * n;
  }

  // Quadratic function: g(n) = n^2
  private static int g(int n) {
    return n * n;
  }
}
