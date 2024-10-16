# CMIS 102: Week 3 Discussion - Adam Langbert

# Adds, subtracts, multiplies, or divides two numbers based on user input. 
def simpleCalculator():

  # Greeting
  print("This simple calculator will add, subtract, multiply, or divide two numbers.")
  operation = int(input("""\nWhat would you like to do?

  (1) Add
  (2) Subtract
  (3) Multiply
  (4) Divide
  """))

  # Terminate program on invalid input.
  # The range(start, stop) function returns a sequence of numbers from start to stop (not including stop).
  # The "in" (or "not in") operator checks if the given value is (or is not) contained in a given sequence.
  # Combining these things, we can check if the input to select the operation is valid.
  if operation not in range(1, 5): quit("\nError: Invalid input.")

  # Get input from user
  num1 = int(input("\nPlease enter the first number: "))
  num2 = int(input("Please enter the second number: "))

  # Display result
  if operation == 1: print("\nResult:", num1 + num2)
  elif operation == 2: print("\nResult:", num1 - num2)
  elif operation == 3: print("\nResult:", num1 * num2)
  elif operation == 4: print("\nResult:", num1 / num2)

simpleCalculator()