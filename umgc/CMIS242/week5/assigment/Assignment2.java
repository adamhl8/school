import java.util.Scanner;

/**
 * Assignment 2: This program allows the user to order different kinds of snacks with different options depending on the
 * type of snack.
 *
 * Adam Langbert | June 17, 2023 | CMIS 242
 */
public class Assignment2 {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | CMIS 242 | June 17, 2023 ====\n");

    while (true) {
      System.out.println("1: Order a Snack\n2: Exit program");
      System.out.print("Enter your selection: ");
      int selection = scanner.nextInt();
      scanner.nextLine(); // Consume left-over newline

      switch (selection) {
        case 1:
          OrderSystem.orderSnack();
          break;
        case 2:
          System.out.println("Thank you for using the program. Goodbye!");
          System.exit(0);
        default:
          System.out.println("Invalid selection.");
      }
    }
  }
}
