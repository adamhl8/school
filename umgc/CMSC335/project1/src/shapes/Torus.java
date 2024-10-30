package src.shapes;

import src.ThreeDimensionalShape;

/**
 * @author Adam Langbert
 * @date Oct 29, 2024
 * @course CMSC 335
 * @assignment Project 1
 * @description Class Torus: Represents a torus shape with major and minor radii and volume
 *              calculation.
 * @java-version Java 17
 */
public class Torus extends ThreeDimensionalShape {
  private double majorRadius;
  private double minorRadius;

  public Torus(double majorRadius, double minorRadius) {
    super();
    this.majorRadius = majorRadius;
    this.minorRadius = minorRadius;
  }

  @Override
  public double getVolume() {
    return 2 * Math.pow(Math.PI, 2) * majorRadius * Math.pow(minorRadius, 2);
  }
}
