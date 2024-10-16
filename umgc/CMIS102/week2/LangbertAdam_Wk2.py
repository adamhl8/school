# CMIS 102: Week 2 Discussion - Adam Langbert

# Prints the average speed based on the inputed distance and time.
def printAverageSpeed():

  # Greeting
  print("This program will calculate the average speed of your trip (in mph).")

  # Get input from user
  distance = int(input("\nPlease enter the distance of your trip in miles: "))
  time = int(input("\nPlease enter how long your trip took in hours: "))

  # Calculate average speed
  averageSpeed = distance / time

  # Print average speed
  print("\nThe average speed of your trip was: " + str(averageSpeed) + " miles per hour")

printAverageSpeed()