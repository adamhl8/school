// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the body of the functions contained in The SubExpression class, which includes
// the constructor that initializes the left and right subexpressions and the static function parse
// parses the subexpression. Addition and subtraction are the two operators that are implemented.

#include <iostream>
#include <sstream>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "plus.h"
#include "minus.h"
#include "multiply.h"
#include "divide.h"
#include "modulo.h"
#include "power.h"
#include "min.h"
#include "max.h"
#include "average.h"
#include "negate.h"
#include "conditional.h"
#include "quadratic.h"

SubExpression::SubExpression(Expression *left, Expression *right)
{
  this->left = left;
  this->right = right;
}

Expression *SubExpression::parse(stringstream &in)
{
  Expression *left;
  Expression *right;
  char operation, paren;

  left = Operand::parse(in);
  in >> ws;

  char op = in.peek();

  if (op == '~')
  {           // Unary operator
    in.get(); // Consume '~'
    in >> ws;
    in.get(); // Consume closing ')'
    return new Negate(left);
  }
  else if (op == '?')
  {           // Ternary operator '?'
    in.get(); // Consume '?'
    Expression *trueExpr = Operand::parse(in);
    Expression *falseExpr = Operand::parse(in);
    in >> ws;
    in.get(); // Consume closing ')'
    return new Conditional(left, trueExpr, falseExpr);
  }
  else if (op == '#')
  {           // Quaternary operator '#'
    in.get(); // Consume '#'
    Expression *expr1 = Operand::parse(in);
    Expression *expr2 = Operand::parse(in);
    Expression *expr3 = Operand::parse(in);
    in >> ws;
    in.get(); // Consume closing ')'
    return new Quadratic(left, expr1, expr2, expr3);
  }
  else if (strchr("+-*/%^<>&>", op))
  {           // Binary operators
    in.get(); // Consume operator
    Expression *right = Operand::parse(in);
    in >> ws;
    in.get(); // Consume closing ')'
    switch (op)
    {
    case '+':
      return new Plus(left, right);
    case '-':
      return new Minus(left, right);
    case '*':
      return new Multiply(left, right);
    case '/':
      return new Divide(left, right);
    case '%':
      return new Modulo(left, right);
    case '^':
      return new Power(left, right);
    case '<':
      return new Min(left, right);
    case '>':
      return new Max(left, right);
    case '&':
      return new Average(left, right);
    }
  }
  else
  {
    throw runtime_error("Invalid operator");
  }
  return nullptr;
}
