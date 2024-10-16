package assignment;
class TemperatureConverter extends Converter {

  public TemperatureConverter() {
    super();
  }

  public TemperatureConverter(double input) {
    super(input);
  }

  @Override
  public double convert() {
    return Double.isNaN(this.getInput()) ? Double.NaN : ((this.getInput() - 32) * 5) / 9;
  }
}
