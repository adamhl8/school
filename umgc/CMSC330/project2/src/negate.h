// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Negate class, which is a subclass of SubExpression.
// It implements the unary negation operation. The evaluate function returns the negation of its operand.

class Negate : public SubExpression
{
public:
  Negate(Expression *operand) : SubExpression(operand, nullptr) {}
  double evaluate()
  {
    return -left->evaluate();
  }
};
