# CMIS 102: Week 5 Discussion - Adam Langbert

# Displays the total number of minutes exercised per week based on user input for each day
def main():

  # Greeting
  print("This program will calculate the total number of minutes you exercised based on your daily activity.\n")

  # Get input from user
  totalMinutes = 0
  day = 1
  while day <= 7:
    minutes = int(input("How many minutes did you exercise on day " + str(day) + "? "))
    totalMinutes += minutes
    day += 1

  # Display result
  print("\nOver 7 days, you exercised for " + str(totalMinutes) + " minutes.")

main()