// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the class definition of the Conditional class, which is a subclass of SubExpression.
// It implements a ternary conditional operation. The evaluate function returns the value of the second
// expression if the first expression is non-zero, otherwise it returns the value of the third expression.

class Conditional : public SubExpression
{
public:
  Conditional(Expression *condition, Expression *trueExpr, Expression *falseExpr)
      : SubExpression(condition, nullptr), trueExpr(trueExpr), falseExpr(falseExpr) {}

  double evaluate()
  {
    return (left->evaluate() != 0.0) ? trueExpr->evaluate() : falseExpr->evaluate();
  }

private:
  Expression *trueExpr;
  Expression *falseExpr;
};
