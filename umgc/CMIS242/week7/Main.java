public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | June 29, 2023 | CMIS 242 ====\n");

    Sedan sedan1 = new Sedan("Toyota", "Corolla", 2022, "White", 5);

    // setYear throws a FutureYearException if the year is more than 1 year into the future
    try {
      sedan1.setYear(2030);
    } catch (FutureYearException e) {
      System.out.println(e.toString());
    }
  }
}
