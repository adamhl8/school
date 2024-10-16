# Adam Langbert
# CMIS 102/7381
# December 07, 2022

print("""-----------------
Adam Langbert
CMIS 102/7381
December 07, 2022
-----------------""")

# This program offers house cleaning or yard service. The total cost of the service will be displayed based on various user input.

import math

# Safely gets interger input from the user. Will keep asking the user for input until they enter an integer.
# displayString is the message to be displayed upon requesting input.
# Optionally takes a validator function which the input is passed to. Validator must return True for the input to be considered valid.
# Optionally takes validatorMessage which is the message that is displayed when validator does not return True.
def int_input(displayString, validator=None, validatorMessage=""):
  userInput = None
  
  while userInput == None:
    inputString = input(displayString)

    try:
      userInput = int(inputString)

      if callable(validator):
        inputIsValid = validator(userInput)
        if not inputIsValid:
          print(validatorMessage)
          userInput = None

    except:
      print("Invalid input: Please enter an integer")
    
  return userInput

# Takes in a list of strings where each string is a menu option to be displayed.
def selection_menu(choices):
  displayString = "\n"
  for i, choice in enumerate(choices):
    displayString += f"({i + 1}) {choice}\n" # e.g. (1) Pick me

  userInput = None
  choiceRange = range(1, len(choices) + 1)

  while userInput not in choiceRange:
    userInput = int_input(displayString)
    if userInput not in choiceRange: print("Invalid input")
  
  return userInput

# Asks user for age to determine if they qualify for a senior discount.
# If user is 65 or older, returns a multiplier of 0.9 (10% discount). Otherwise returns 1. 
def senior_discount():
  age = int_input("\n(Senior Discount) What is your age? ", lambda num: num > 0, "Age must be greater than 0")
  if age >= 65:
    print("You qualify for the 10% senior discount!")
    return 0.9

  print("Sorry, you do not qualify for the senior discount at this time.")
  return 1

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

  totalCost *= senior_discount()
  return (round(totalCost, 2), cleaningTypeString, houseType)

# Displays the different types of cleaning and displays the total cost based on user input.
def house_cleaning():
  print("\nThe total cost of house cleaning is based on the type of cleaning and the number of rooms.")
  cleaningTypes = ["Floors: \t\t$30", "Windows: \t\t$20", "Quick Dusting: \t$10"]
  print("What type of cleaning would you like?")
  selectedCleaningType = selection_menu(cleaningTypes)

  # Prompt user for number of rooms
  numberOfRooms = int_input("\nHow many rooms are in your house? ", lambda num: num > 0, "At least one room is required")

  # Calculate total cost and get strings for output
  totalCost, cleaningTypeString, houseType = calculate_cleaning_cost(selectedCleaningType, numberOfRooms)

  # Display results
  print("\nThe total cost of a " + cleaningTypeString + " cleaning for a " + houseType + " house is:")
  print("$" + str(totalCost))

def calculate_yard_service_cost(selectedService):
  # Cost of each service
  mowingCost = 0.05 # per sqft
  edgingCost = 0.25 # per ft
  shrubPruningCost = 10 # per shrub

  # Set totalCost based on passed in value
  # Also set serviceString to be used in output
  totalCost = 0
  serviceString = ""
  if selectedService == 1:
    squareFootage = int_input("\nHow many square feet is your yard? ", lambda num: num > 0, "Square footage must be greater than 0")
    totalCost = squareFootage * mowingCost
    serviceString = "Mowing"
  elif selectedService == 2:
    squareFootage = int_input("\nHow many square feet is your yard? ", lambda num: num > 0, "Square footage must be greater than 0")
    # Yard is assumed to be a square
    edgeFootage = math.sqrt(squareFootage) * 4
    totalCost = edgeFootage * edgingCost
    serviceString = "Edging"
  elif selectedService == 3:
    numberOfShrubs = int_input("\nHow many shrubs do you wants pruned? ", lambda num: num > 0, "There must be at least 1 shrub")
    totalCost = numberOfShrubs * shrubPruningCost
    serviceString = "Shrub Pruning"

  totalCost *= senior_discount()
  return (round(totalCost, 2), serviceString)

# Displays the different yard services and displays the total cost based on user input.
def yard_service():
  services = ["Mowing: \t\t5¢/sqft", "Edging: \t\t25¢/ft", "Shrub Pruning: \t$10/shrub"]
  print("\nPlease select a service:")
  selectedService = selection_menu(services)

  # Calculate total cost and get strings for output
  totalCost, serviceString = calculate_yard_service_cost(selectedService)

  # Display results
  print("\nThe total cost of the " + serviceString + " service is: ")
  print("$" + str(totalCost))

# Display the different services and call the related service function based on user input.
def main():
  services = ["House Cleaning", "Yard Service"]
  print("\nWelcome! We offer House Cleaning and Yard Service. Please select the service you would like:")
  selectedService = selection_menu(services)

  if selectedService == 1: house_cleaning()
  elif selectedService == 2: yard_service()

main()
