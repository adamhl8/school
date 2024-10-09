// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Min class, which is a subclass of SubExpression.
// It implements the minimum operation between two expressions. The evaluate function returns
// the smaller of the two subexpression values.

class Min : public SubExpression
{
public:
  Min(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    double l = left->evaluate();
    double r = right->evaluate();
    return (l < r) ? l : r;
  }
};
