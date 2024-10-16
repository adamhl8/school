import java.util.Calendar;

public class Car {
  private String make;
  private String model;
  private int year;
  private String color;

  public Car(String make, String model, int year, String color) {
    this.make = make;
    this.model = model;
    this.setYear(year);
    this.color = color;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    // year can't be more than 1 year into the future
    if (year > Calendar.getInstance().get(Calendar.YEAR) + 1) {
      throw new FutureYearException(year);
    }
    this.year = year;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void displayDetails() {
    System.out.println("Car Details:\nMake: " + getMake() + "\nModel: " + getModel() + "\nYear: " + getYear()
        + "\nColor: " + getColor() + "\n");
  }
}
