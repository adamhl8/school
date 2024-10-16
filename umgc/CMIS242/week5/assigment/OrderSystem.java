import java.util.Scanner;

public class OrderSystem {
  private static int id = 0;
  private static Scanner scanner = new Scanner(System.in);

  // Private constructor to hide the default public constructor
  private OrderSystem() {
  }

  public static void orderSnack() {
    System.out.print("Do you want Fruit Snack (1) or Salty Snack (2): ");
    int snackType = scanner.nextInt();
    scanner.nextLine(); // Consume left-over newline

    System.out.print("What size do you want? (S), (M), or (L): ");
    String size = scanner.nextLine().toUpperCase();

    Snack snack;
    switch (snackType) {
      case 1:
        System.out.print("Do you want citrus fruit included? (true) or (false): ");
        boolean citrusFruit = scanner.nextBoolean();
        scanner.nextLine();
        snack = new FruitSnack("F" + (++id), size, citrusFruit);
        break;
      case 2:
        System.out.print("Do you want nut snack included? (true) or (false): ");
        boolean nutSnack = scanner.nextBoolean();
        scanner.nextLine();
        snack = new SaltySnack("S" + (++id), size, nutSnack);
        break;
      default:
        System.out.println("Invalid snack type.");
        return;
    }

    System.out.printf("\nYou have chosen the following snack:\n%s\n", snack);
  }
}
