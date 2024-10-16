# Adam Langbert
# CMIS 102/7381
# November 15, 2022

print("""----------------
Adam Langbert
CMIS 102/7381
November 15, 2022
----------------""")

# Calculates and returns the cost of cleaning based on cleaningType and the numberOfRooms
def calculate_cleaning_cost(cleaningType, numberOfRooms):
  # Costs of each cleaning type
  floorsCost = 30
  windowsCost = 20
  dustingCost = 10
  # Room size cutoffs
  # small if rooms <= smallCutoff, medium if rooms <= mediumCutoff, large otherwise
  smallCutoff = 2
  mediumCutoff = 5
  # Room size multipliers
  # Cost will be increased by the respective multiplier based on room size
  mediumMultiplier = 2
  largeMultiplier = 3

  # Set cleaningTypeCost based on passed in value
  # Also set cleaningTypeString to be used in output
  cleaningTypeCost = 0
  cleaningTypeString = ""
  if cleaningType == 1:
    cleaningTypeCost = floorsCost
    cleaningTypeString = "Floors"
  elif cleaningType == 2:
    cleaningTypeCost = windowsCost
    cleaningTypeString = "Windows"
  elif cleaningType == 3:
    cleaningTypeCost = dustingCost
    cleaningTypeString = "Quick Dusting"

  # Calculate total cost
  # Also set houseType string to be used in output
  totalCost = 0
  houseType = ""
  if numberOfRooms <= smallCutoff:
    totalCost = cleaningTypeCost
    houseType = "Small"
  elif numberOfRooms <= mediumCutoff:
    totalCost = cleaningTypeCost * mediumMultiplier
    houseType = "Medium"
  else:
    totalCost = cleaningTypeCost * largeMultiplier
    houseType = "Large"

  return (totalCost, cleaningTypeString, houseType)

# This program calculates the total cost of house cleaning based on the type of cleaning and the number of rooms.
def main():
  # Welcome user and prompt user for cleaning type.
  print("\nWelcome! This program will calculate the total cost of house cleaning based on the type of cleaning and the number of rooms.")
  cleaningType = int(input("""\nWhat type of cleaning would you like?

  (1) Floors: \t\t$30
  (2) Windows: \t\t$20
  (3) Quick Dusting: \t$10
  """))

  # Terminate program on invalid input.
  if cleaningType not in range(1, 4): quit("\nError: Invalid input.")

  # Prompt user for number of rooms
  numberOfRooms = int(input("\nHow many rooms are in your house? "))

  # Number of rooms must be greater than 0.
  if numberOfRooms < 1: quit("\nError: At least 1 room is required.")

  # Calculate total cost and get strings for output
  totalCost, cleaningTypeString, houseType = calculate_cleaning_cost(cleaningType, numberOfRooms)

  # Display results
  print("\nThe total cost of a " + cleaningTypeString + " cleaning for a " + houseType + " house is:")
  print("$" + str(totalCost))

main()
