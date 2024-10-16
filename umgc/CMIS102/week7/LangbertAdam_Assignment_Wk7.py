# Adam Langbert
# CMIS 102/7381
# December 06, 2022

print("""-----------------
Adam Langbert
CMIS 102/7381
December 06, 2022
-----------------""")

# This program asks the user for details about their trip (number of people, days, cost of food and gas for each day)
# and displays the totals. Also displays the share of the total cost each person is responsible for.
# Amounts are assumed to be in USD.
def main():
  # Display greeting
  print("\nWelcome! This program will ask you for the details of your trip and display the total cost of food, gas, and the overall trip. It will also display each person's share of the total cost.")

  # Prompt user for trip details
  numberOfPeople = int(input("\nHow many people went on the trip? "))
  numberOfDays = int(input("How long was the trip in days? "))

  # Arrays to store food and gas costs
  foodCosts = []
  gasCosts = []

  # Prompt user for cost of food and gas for each day
  for i in range(numberOfDays):
    print(f"\nOn day {i + 1}, how much was:")

    foodCost = float(input("The cost of food? "))
    foodCosts.append(foodCost)

    gasCost = float(input("The cost of gas? "))
    gasCosts.append(gasCost)

  totalGasCost = 0
  totalFoodCost = 0
  totalCost = 0

  # Calculate totals
  # The zip() function allows us to iterate through multiple arrays at a time
  for foodCost, gasCost in zip(foodCosts, gasCosts):
    totalFoodCost += foodCost
    totalGasCost += gasCost
    totalCost += foodCost + gasCost

  # Display results
  # Round each result to 2 decimal places
  print(f"\nThe total cost of gas for the trip is: ${round(totalGasCost, 2)}")
  print(f"The total cost of food for the trip is: ${round(totalFoodCost, 2)}")
  print(f"The total cost of the trip is: ${round(totalCost, 2)}")
  print(f"Split evenly, each person is responsible for: ${round(totalCost / numberOfPeople, 2)}")

main()
