// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Multiply class, which is a subclass of SubExpression.
// It implements the multiplication operation between two expressions. The evaluate function returns
// the product of the values of the two subexpressions.

class Multiply : public SubExpression
{
public:
  Multiply(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    return left->evaluate() * right->evaluate();
  }
};
