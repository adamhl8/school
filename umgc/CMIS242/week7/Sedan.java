public class Sedan extends Car {
  private int numberOfSeats;

  public Sedan(String make, String model, int year, String color, int numberOfSeats) {
    super(make, model, year, color);
    this.numberOfSeats = numberOfSeats;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  @Override
  public void displayDetails() {
    System.out.println("Sedan Details:\nMake: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear()
        + "\nColor: " + getColor() + "\nNumber of Seats: " + numberOfSeats + "\n");
  }
}
