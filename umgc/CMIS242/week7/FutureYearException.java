public class FutureYearException extends RuntimeException {
  public FutureYearException(int year) {
    super(String.format("Invalid Year: %d is in the future!", year));
  }
}
