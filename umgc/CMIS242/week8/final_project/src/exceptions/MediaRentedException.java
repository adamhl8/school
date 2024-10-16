package src.exceptions;

public class MediaRentedException extends RuntimeException {
  public MediaRentedException(int id) {
    super(String.format("Media with ID of %d has already been rented.", id));
  }
}
