# CMIS 102: Week 7 Discussion - Adam Langbert

# This program will prompt the user for 5 values (hours), convert each of those values to minutes, and display the results to the user.
def main():

  # Greeting
  print("Welcome! At each input, please provide a number of hours. The hours will be coverted to minutes and displayed to you.\n")

  hoursArray = []

  # Get input from user
  for i in range(5):
    hours = int(input(f"({i}) Please enter the number of hours: "))
    hoursArray.append(hours)
  
  # Convert hours to minutes
  for i in range(len(hoursArray)):
    hoursArray[i] = hoursArray[i] * 60
  
  # Display results
  print("\nYour hours converted to minutes:")
  for i, minutes in enumerate(hoursArray):
    print(f"({i}) Minutes: {minutes}")

main()