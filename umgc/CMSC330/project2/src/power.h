// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Power class, which is a subclass of SubExpression.
// It implements the exponentiation operation between two expressions. The evaluate function returns
// the result of raising the left subexpression to the power of the right subexpression.

class Power : public SubExpression
{
public:
  Power(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    return pow(left->evaluate(), right->evaluate());
  }
};
