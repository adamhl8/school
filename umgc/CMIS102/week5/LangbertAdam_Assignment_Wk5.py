# Adam Langbert
# CMIS 102/7381
# November 21, 2022

print("""-----------------
Adam Langbert
CMIS 102/7381
November 21, 2022
-----------------""")

# Calculates average grade (weighted)
def calculate_grade(studentName):
  # Grade weights
  discussionWeight = 0.15
  quizWeight = 0.30
  assignmentWeight = 0.55

  # Get user input
  print("\nPlease enter " + studentName + "'s grades (as a number, e.g. 80 for 80%) for the following:")

  discussionGrade = int(input("Discussion grade: ")) / 100
  if discussionGrade < 0: quit("\nError: Grade cannot be less than 0.")

  quizGrade = int(input("Quiz grade: ")) / 100
  if quizGrade < 0: quit("\nError: Grade cannot be less than 0.")

  assignmentGrade = int(input("Assignment grade: ")) / 100
  if assignmentGrade < 0: quit("\nError: Grade cannot be less than 0.")

  # Calculate weighted average
  weightedAverageGrade = (discussionGrade * discussionWeight) + (quizGrade * quizWeight) + (assignmentGrade * assignmentWeight)
  return round(weightedAverageGrade * 100, 2)

# This program displays the average grades for a list of students and also displays the student with the highest average grade.
def main():
  # Display greeting
  print("\nWelcome! This program will calculate and display the grades for a list of students and display the student with the highest grade.")

  # List of student names
  studentNames = ["Kyle", "John", "Erin", "Abby"]
  print("Students:", studentNames)

  # Calculate and display weighted average grade for each student in the list
  # Store the student with the highest grade
  highestGrade = None
  highestGradeName = "NONE"
  for student in studentNames:
    grade = calculate_grade(student)
    print("\n" + student + "'s grade: " + str(grade) + "%")
    if highestGrade is None or grade > highestGrade :
      highestGrade = grade
      highestGradeName = student

  # Display student with highest grade
  print("\n" + highestGradeName + " achieved the highest grade with a grade of: " + str(highestGrade) + "%")

main()
