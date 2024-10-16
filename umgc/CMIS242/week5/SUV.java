public class SUV extends Car {
  private boolean fourWheelDrive;

  public SUV(String make, String model, int year, String color, boolean fourWheelDrive) {
    super(make, model, year, color);
    this.fourWheelDrive = fourWheelDrive;
  }

  public boolean isFourWheelDrive() {
    return fourWheelDrive;
  }

  public void setFourWheelDrive() {
    this.fourWheelDrive = true;
  }

  // Overloaded
  public void setFourWheelDrive(boolean fourWheelDrive) {
    this.fourWheelDrive = fourWheelDrive;
  }

  @Override
  public void displayDetails() {
    System.out.println("SUV Details:\nMake: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear()
        + "\nColor: " + getColor() + "\nFour Wheel Drive: " + fourWheelDrive + "\n");
  }
}
