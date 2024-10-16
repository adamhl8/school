#Farinas, Justin J. CMIS 102 7381, 12/6/2022

#Array Modifier

def main ():


    print('Hello! Welcome to the 5 value multiplier program!')
    
    number = list()
    count = 1
    while len(number) < 5: # This caps the amount of values that could be added to the list to 5 only.
        num = int(input('What number would you like to add to the list , keep note that you can only add 5 numbers!\n'))
        
        number.append(num) # This adds the value to the variable number.
        
        print('Current list: {}'.format(number)) # Displays the current list per value.
        
        count += 1
        
    for val in range(len(number)): # Creates a for loop for each of the values that the user has inputted.
        mul = int(input('What value do you want to multiply {} by?\n'.format(number[val]))) # Asks the user for a multiplier for the current value.
        
        number[val] = number[val] * mul # Multiplies said user inputted value to the current (number) on the list.

    # Modifications by Adam Langbert
    # Subtract 1 from each value to confuse user :)
    for i in range(len(number)):
        number[i] = number[i] - 1
        
    print('Your total values conclude to:\n')
    for val in range(len(number)): # Creates a for loop for each of the final values that have been multiplied per user input.
        print('Value # {} is {}\n'.format([val+1], number[val])) # Prints out the values that have been multiplied line by line.
    
main()
 
