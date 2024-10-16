package src.media;

import java.util.Calendar;

public class EBook extends Media {
  private int numChapters;

  public EBook(int id, String title, int year, boolean isRented, int numChapters) {
    super(id, title, year, isRented);
    this.numChapters = numChapters;
  }

  public int getNumChapters() {
    return numChapters;
  }

  public void setNumChapters(int numChapters) {
    this.numChapters = numChapters;
  }

  @Override
  public double getRentalFee() {
    double fee = numChapters * 0.10;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    if (this.getYear() == currentYear)
      fee += 1;
    return fee;
  }

  @Override
  public String toString() {
    return String.format("""
        = EBook =
        ID: %d
        Title: %s
        Year: %d
        Chapters: %d
        Available to rent: %s""",
        this.getId(),
        this.getTitle(),
        this.getYear(),
        this.getNumChapters(),
        this.isRented() ? "No" : "Yes");
  }
}
