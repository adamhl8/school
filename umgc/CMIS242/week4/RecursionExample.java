public class RecursionExample {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | June 7, 2023 | CMIS 242 ====\n");
    int num = 8;
    System.out.println("The factorial of " + num + " is " + factorial(num));
  }

  public static int factorial(int num) {
    if (num == 0)
      return 1;
    else
      return num * factorial(num - 1);
  }
}
