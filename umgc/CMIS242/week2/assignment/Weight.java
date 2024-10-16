// This class allows for the creation of Weight objects that have pound and ounce value.
public class Weight {
  private final int OUNCES_IN_A_POUND = 16;
  private int pounds;
  private double ounces;
  // totalWeightInOunces allows for easier comparisons between different instances of Weight.
  private double totalWeightInOunces;

  public Weight(int pounds, double ounces) {
    this.pounds = pounds;
    this.ounces = ounces;
    normalize();
  }

  public int getPounds() {
    return pounds;
  }

  public double getOunces() {
    return ounces;
  }

  public double getTotalWeightInOunces() {
    return totalWeightInOunces;
  }

  // Returns the Weight's total weight in ounces.
  private double toOunces() {
    return this.pounds * this.OUNCES_IN_A_POUND + ounces;
  }

  // Normalizes pounds/ounces. That is, a Weight that has more ounces than are in a pound will be properly adjusted.
  // e.g. 2 pounds 24 ounces -> 3 pounds 8 ounces
  private void normalize() {
    if (this.ounces >= this.OUNCES_IN_A_POUND) {
      // We floor the result of ounces / OUNCES_IN_A_POUND to get the quotient, which is the number of pounds to add.
      this.pounds += (int) Math.floor(this.ounces / this.OUNCES_IN_A_POUND);
      // The remainder is the remaining number of ounces.
      this.ounces = this.ounces % this.OUNCES_IN_A_POUND;
    }
    // Set and make sure totalWeightInOunces is correct.
    this.totalWeightInOunces = this.toOunces();
  }

  // Returns true if the current Weight is less than the passed in Weight.
  public boolean lessThan(Weight weight) {
    return this.totalWeightInOunces < weight.getTotalWeightInOunces();
  }

  // Adds the passed in Weight to the current Weight.
  public void addTo(Weight weight) {
    this.pounds += weight.getPounds();
    this.ounces += weight.getOunces();
    normalize();
  }

  public String toString() {
    return String.format("%d pounds and %.2f ounces", this.pounds, this.ounces);
  }
}
