public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | June 3, 2023 | CMIS 242 ====\n");

    Sedan sedan1 = new Sedan("Toyota", "Corolla", 2022, "White", 5);
    SUV suv1 = new SUV("Mazda", "CX-5", 2021, "Silver", true);

    sedan1.displayDetails();
    suv1.displayDetails();

    // setNumberOfSeats only exists on Sedan
    sedan1.setNumberOfSeats(4);
    // setYear is from the Car superclass
    sedan1.setYear(2020);
    sedan1.displayDetails();
  }
}
