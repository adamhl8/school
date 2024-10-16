#Program to calculate the number of times a person farts during a road trip
total = 0.00

# Modifications by Adam Langbert
# Calculate and display average
count = 0

while True:
    print('Enter another positive value if you wish to continue. Enter a negative number to calculate the sum.')
    number = float(input('Enter the number of times your friend farts during a road trip: '))
    if number >= 0: # Check for positive numbers in loop if no positive returns sum
        total += number
        count += 1
    else:  
        break
print('The sum is: ', total)
print('The average is:', total / count)