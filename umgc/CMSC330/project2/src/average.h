// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Average class, which is a subclass of SubExpression.
// It implements the average operation between two expressions. The evaluate function returns the
// arithmetic mean of the two subexpression values.

class Average : public SubExpression
{
public:
  Average(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    return (left->evaluate() + right->evaluate()) / 2.0;
  }
};
