// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Max class, which is a subclass of SubExpression.
// It implements the maximum operation between two expressions. The evaluate function returns
// the larger of the two subexpression values.

class Max : public SubExpression
{
public:
  Max(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    double l = left->evaluate();
    double r = right->evaluate();
    return (l > r) ? l : r;
  }
};
