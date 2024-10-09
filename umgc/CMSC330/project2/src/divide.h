// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Divide class, which is a subclass of SubExpression.
// It implements the division operation between two expressions. The evaluate function returns the
// quotient of the left subexpression divided by the right subexpression. It includes error checking
// for division by zero.

class Divide : public SubExpression
{
public:
  Divide(Expression *left, Expression *right) : SubExpression(left, right) {}
  double evaluate()
  {
    double denominator = right->evaluate();
    if (denominator == 0.0)
    {
      throw runtime_error("Division by zero");
    }
    return left->evaluate() / denominator;
  }
};
