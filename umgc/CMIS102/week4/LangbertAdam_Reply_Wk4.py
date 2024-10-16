#Lemmar Wilson
#CMIS 102 7381
#Discussion Week4

#Welcome to the sales tax calculator
#This program will calculate sales tax for items you input

def main():
    #Display welcome message and shows the app functions
    print('Welcome to the sales tax calculator'
          'This program will calculate sales tax for items you input')

    #prompt user for price and amount of items
    numItems, itemCost = UserInput()

    #Calculate sales tax
    sales_tax = calCost( numItems, itemCost)

    #Display Sales tax
    displayTax(sales_tax)

#Functions
def UserInput():
    #prompt user for # of items
    numItem = int(input('How many items do you have? '))

    #prompt user for cost of each item
    itemCost = int(input('How much does each item cost? '))

    return (itemCost, numItem)

def calCost(itemCost,numItem):
    # Modifications - Adam Langbert
    # Reduce sales tax for items over $100
    if itemCost >= 100: return itemCost * numItem * 0.05
    
    sales_tax = (itemCost * numItem) * .1

    return (sales_tax)

def displayTax(sales_tax):
    print('The total sales tax is,', sales_tax)

#execute
main()
