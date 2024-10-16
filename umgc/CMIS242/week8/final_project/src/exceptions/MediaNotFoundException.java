package src.exceptions;

public class MediaNotFoundException extends RuntimeException {
  public MediaNotFoundException(int id) {
    super(String.format("Media with ID of %d does not exist.", id));
  }
}
