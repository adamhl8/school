package assignment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUIConverter extends JFrame {
  public GUIConverter() {
    JButton distanceButton = new JButton("Distance Converter");
    JButton temperatureButton = new JButton("Temperature Converter");
    JButton exitButton = new JButton("Exit");

    distanceButton.addActionListener(e -> convert(
        "Enter distance in Miles:",
        "%.2f Miles equals %.2f Kilometers",
        new DistanceConverter()));

    temperatureButton.addActionListener(e -> convert(
        "Enter temperature in Fahrenheit:",
        "%.2f F equals %.2f C",
        new TemperatureConverter()));

    exitButton.addActionListener(e -> System.exit(0));

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    add(distanceButton, c);
    c.gridy = 1;
    add(temperatureButton, c);
    c.gridy = 2;
    add(exitButton, c);
    pack();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void convert(String inputPrompt, String resultMessage, Converter converter) {
    try {
      double input = Double.parseDouble(JOptionPane.showInputDialog(inputPrompt));
      converter.setInput(input);
      JOptionPane.showMessageDialog(null, String.format(resultMessage, input, converter.convert()));
    } catch (NumberFormatException ex) {
      // Handling the case where input is invalid (input is empty string or not parsable as a double)
      JOptionPane.showMessageDialog(null, "Invalid input.");
    } catch (NullPointerException ex) {
      // Handling the case where user selects Cancel (input will be null)
      return;
    }
  }
}
