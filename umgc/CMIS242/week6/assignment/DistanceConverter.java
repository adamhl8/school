package assignment;
class DistanceConverter extends Converter {

  public DistanceConverter() {
    super();
  }

  public DistanceConverter(double input) {
    super(input);
  }

  @Override
  public double convert() {
    return Double.isNaN(this.getInput()) ? Double.NaN : this.getInput() * 1.609;
  }
}
