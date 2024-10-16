# Adam Langbert
# CMIS 102/7381
# November 29, 2022

print("""-----------------
Adam Langbert
CMIS 102/7381
November 29, 2022
-----------------""")

# min/max password length
minimumLength = 6
maximumLength = 20

# Checks if password is valid length
def password_is_valid_length(password):
  return len(password) >= minimumLength and len(password) <= maximumLength

# Checks if password contains at least 1 letter and 1 number
def password_contains_required_characters(password):
  foundAlpha = False
  foundDigit = False
  
  for char in password:
    if char.isalpha(): foundAlpha = True
    if char.isdigit(): foundDigit = True
    if foundAlpha and foundDigit: return True
  
  return False

# Checks if password contains no spaces
def password_contains_no_spaces(password):
  for char in password:
    if char.isspace(): return False
  return True

# Uses available password functions to check if password is valid
def password_is_valid(password):
  if not password_is_valid_length(password):
    print("\nError: Password must be between 6 and 20 characters.")
    return False
  
  if not password_contains_required_characters(password):
    print("\nError: Password must contain at least 1 letter and 1 number.")
    return False
  
  if not password_contains_no_spaces(password):
    print("\nError: Password cannot contain spaces.")
    return False

  return True

# This program takes in a password and checks if it meets the requirements
def main():
  # Display greeting
  print("\nWelcome! This program will ask you for a password and let you know if it meets the requirements.")

  # Display password requirements
  print(("\nPassword must:"
  f"\n- Be between {minimumLength} and {maximumLength} in length"
  f"\n- Contain at least 1 letter and 1 number"
  f"\n- Not contain spaces"))

  # Prompt user for password
  password = input("\nPlease enter a password: ")
  
  passwordIsValid = password_is_valid(password)

  if passwordIsValid: print("\nYour password is valid!")

main()
