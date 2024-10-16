public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | June 14, 2023 | CMIS 242 ====\n");

    // The following demonstrates overriding and overloading.
    Car car1 = new Car("Honda", "Civic", 2018, "Grey");
    Sedan sedan1 = new Sedan("Toyota", "Corolla", 2022, "White", 5);
    SUV suv1 = new SUV("Mazda", "CX-5", 2021, "Silver", true);

    car1.displayDetails();
    // On Sedan and SUV, the displayDetails method overrides Car's displayDetails.
    suv1.displayDetails();
    sedan1.displayDetails();

    // On SUV, the setFourWheelDrive is overloaded. Calling it without an argument will set it to true by default.
    suv1.setFourWheelDrive(false);
    suv1.displayDetails();
    suv1.setFourWheelDrive();
    suv1.displayDetails();
  }
}
