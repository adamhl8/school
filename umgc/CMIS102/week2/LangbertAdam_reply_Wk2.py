
#This program will demonstrate the cost of bread in Nab's store

def main():
    
    # Initializing variables
    breadPrice = 25
    bagPrice = 2
    discount= 15
    # Display a welcome message
    print("Welcome to Nab's store")
    # Prompt the user for number of bread
    number_of_bread = eval(input("how many bread:"))
    print("the number of bread", number_of_bread)
    #compute the total cost of bread
    total_cost_of_bread = number_of_bread * 25
    # Display the total cost of bread
    print("total cost of bread", total_cost_of_bread)
    #Prompt the user for the number of bags
    number_of_bags = eval(input("how many bags needed: "))
    # compute the total cost of bags
    total_cost_of_bags = number_of_bags * 2 
    # Display the total cost of bags
    print("the total cost of bags", total_cost_of_bags)
    # compute the cost of your purchase
    purchase_cost = total_cost_of_bread + total_cost_of_bags
    # Display the purchase cost
    print("the purchase cost", purchase_cost)
    #compute the final cost
    final_cost = purchase_cost - discount
    #display final cost
    print("final cost", final_cost)
    #Display a Thank you message
    print("Thank you for your purchase!")

    # Modifications - Adam Langbert
    # Print an adjusted final cost based on user inputed percent discount.
    extraPercentDiscount = int(input("How much of a % discount do you want? (e.g. enter 50 for 50%) ")) / 100
    print("The final cost including your extra discount is: $" +  str(final_cost * (1 - extraPercentDiscount)))
    

main()
