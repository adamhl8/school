package src.media;

public class MovieDVD extends Media {
  private double size;

  public MovieDVD(int id, String title, int year, boolean isRented, double size) {
    super(id, title, year, isRented);
    this.size = size;
  }

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return String.format("""
        = MovieDVD =
        ID: %d
        Title: %s
        Year: %d
        Size: %.2fMB
        Available to rent: %s""",
        this.getId(),
        this.getTitle(),
        this.getYear(),
        this.getSize(),
        this.isRented() ? "No" : "Yes");
  }
}
