# CMIS 102: Week 4 Discussion - Adam Langbert

# Displays wattage based on user input for voltage and amperage.
def main():

  # Greeting
  print("This program will calculate the wattage for a given voltage and amperage.")

  # Get input from user
  voltage = int(input("\nPlease enter the voltage: "))
  amperage = int(input("Please enter the amperage: "))

  wattage = getWattage(voltage, amperage)

  # Display result
  print("\nThe wattage of " + str(voltage) + " volts and " + str(amperage) + " amps is: " + str(wattage))

# Calculates wattage based on voltage and amperage.
def getWattage(voltage, amperage):
  return voltage * amperage

main()