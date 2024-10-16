# Adam Langbert
# CMIS 102/7381
# November 1, 2022

print("""----------------
Adam Langbert
CMIS 102/7381
November 1, 2022
----------------""")

# This program calculates the weekly pay for a paper carrier based on user input.
def main():
  # Each newspaper costs $5. Carrier earns 25% of each newspaper sold.
  newspaperCost = 5
  commissionPercent = 0.25

  # Welcome user and prompt for needed information.
  print("\nWelcome! This program will calculate your weekly pay as a paper carrier.")
  print("Each newspaper costs $" + str(newspaperCost) + " and you will earn " + str(commissionPercent * 100) + "% on each one sold.")
  numberOfNewspapers = int(input("\nHow many papers are on your route? (Newspapers delieverd daily) "))
  daysPerWeek = int(input("How many days per week do you deliver papers on this route? "))
  totalOfTips = int(input("What is the total amount of tips you expect to receive in dollars? "))

  # Calculate results
  totalNewspapers = numberOfNewspapers * daysPerWeek
  weeklySalary = totalNewspapers * newspaperCost * commissionPercent
  totalWeeklyPay = weeklySalary + totalOfTips

  # Display results
  print("\nResults:")
  print("Total number of papers delivered:\t" + str(totalNewspapers))
  print("Weekly salary:\t\t\t\t$" + str(weeklySalary))
  print("Tips:\t\t\t\t\t$" + str(totalOfTips))
  print("Total Pay:\t\t\t\t$" + str(totalWeeklyPay))

main()
