import java.util.Scanner;

class ElectronicDevice {
  void switchOn() {
    System.out.println("The electronic device is switched on");
  }
}

class Laptop extends ElectronicDevice {
  @Override
  void switchOn() {
    System.out.println("The laptop is powered on and booted up");
  }
}

class Television extends ElectronicDevice {
  @Override
  void switchOn() {
    System.out.println("The television is switched on and displaying a channel");
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println("==== Adam Langbert | June 21, 2023 | CMIS 242 ====\n");

    Scanner scanner = new Scanner(System.in);
    System.out.println("Select the device you want to switch on:");
    System.out.println("(1) Laptop");
    System.out.println("(2) Television");
    int choice = scanner.nextInt();

    ElectronicDevice device;

    switch (choice) {
      case 1:
        device = new Laptop();
        break;
      case 2:
        device = new Television();
        break;
      default:
        System.out.println("Invalid choice. Defaulting to Laptop.");
        device = new Laptop();
    }

    // The switchOn method that is actually called is determined during run-time depending on the type that was chosen.
    device.switchOn();

    scanner.close();
  }
}
