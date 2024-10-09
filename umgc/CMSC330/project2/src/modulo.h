// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Modulo class, which is a subclass of SubExpression.
// It implements the modulo operation between two expressions. The evaluate function returns the
// remainder of the integer division of the left subexpression by the right subexpression.

class Modulo : public SubExpression
{
public:
  Modulo(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    int leftVal = static_cast<int>(left->evaluate());
    int rightVal = static_cast<int>(right->evaluate());
    return static_cast<double>(leftVal % rightVal);
  }
};
