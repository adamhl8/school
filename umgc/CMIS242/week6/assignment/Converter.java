package assignment;
abstract class Converter {
  private double input;

  public Converter() {
    this.input = Double.NaN;
  }

  public Converter(double input) {
    this.input = input;
  }

  public double getInput() {
    return this.input;
  }

  public void setInput(double input) {
    this.input = input;
  }

  public double convert() {
    return this.input;
  }
}
