package src.media;

public abstract class Media {
  private int id;
  private String title;
  private int year;

  private boolean isRented;

  protected Media(int id, String title, int year, boolean isRented) {
    this.id = id;
    this.title = title;
    this.year = year;
    this.isRented = isRented;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public boolean isRented() {
    return isRented;
  }

  public void setRented(boolean isRented) {
    this.isRented = isRented;
  }

  public double getRentalFee() {
    return 3.50;
  }
}
