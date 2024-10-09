// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Plus class, which is a subclass of SubExpression.
// It implements the addition operation between two expressions. The evaluate function returns
// the sum of the values of the two subexpressions.

class Plus : public SubExpression
{
public:
  Plus(Expression *left, Expression *right) : SubExpression(left, right)
  {
  }
  double evaluate()
  {
    return left->evaluate() + right->evaluate();
  }
};
