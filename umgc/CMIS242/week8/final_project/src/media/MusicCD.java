package src.media;

import java.util.Calendar;

public class MusicCD extends Media {
  // minutes
  private int length;

  public MusicCD(int id, String title, int year, boolean isRented, int length) {
    super(id, title, year, isRented);
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  @Override
  public double getRentalFee() {
    double fee = length * 0.02;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    if (this.getYear() == currentYear)
      fee += 1;
    return fee;
  }

  @Override
  public String toString() {
    return String.format("""
        = MusicCD =
        ID: %d
        Title: %s
        Year: %d
        Length: %d minutes
        Available to rent: %s""",
        this.getId(),
        this.getTitle(),
        this.getYear(),
        this.getLength(),
        this.isRented() ? "No" : "Yes");
  }
}
