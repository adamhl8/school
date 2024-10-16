# Adam Langbert
# CMIS 102/7381
# November 8, 2022

print("""----------------
Adam Langbert
CMIS 102/7381
November 8, 2022
----------------""")

# This program calculates the total cost of house cleaning based on the type of cleaning and the number of rooms.
def main():
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

  # Welcome user and prompt user for cleaning type.
  print("\nWelcome! This program will calculate the total cost of house cleaning based on the type of cleaning and the number of rooms.")
  cleaningType = int(input("""\nWhat type of cleaning would you like?

  (1) Floors: \t\t$30
  (2) Windows: \t\t$20
  (3) Quick Dusting: \t$10
  """))

  # Terminate program on invalid input.
  if cleaningType not in range(1, 4): quit("\nError: Invalid input.")

  # Set cleaningTypeCost based on user input
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

  # Prompt user for number of rooms
  numberOfRooms = int(input("\nHow many rooms are in your house? "))

  # Number of rooms must be greater than 0.
  if numberOfRooms < 1: quit("\nError: At least 1 room is required.")

  # Calculate total cost
  # Set houseType string to be used in output
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

  # Display results
  print("\nThe total cost of a " + cleaningTypeString + " cleaning for a " + houseType + " house is:")
  print("$" + str(totalCost))

main()
