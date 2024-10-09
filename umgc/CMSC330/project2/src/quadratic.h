// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Quadratic class, which is a subclass of SubExpression.
// It implements a quaternary conditional operation. The evaluate function returns the value of the second,
// third, or fourth expression based on whether the first expression is negative, zero, or positive.

class Quadratic : public SubExpression
{
public:
  Quadratic(Expression *condition, Expression *expr1, Expression *expr2, Expression *expr3)
      : SubExpression(condition, nullptr), expr1(expr1), expr2(expr2), expr3(expr3) {}

  double evaluate()
  {
    double cond = left->evaluate();
    if (cond < 0.0)
      return expr1->evaluate();
    else if (cond == 0.0)
      return expr2->evaluate();
    else // cond > 0.0
      return expr3->evaluate();
  }

private:
  Expression *expr1;
  Expression *expr2;
  Expression *expr3;
};
