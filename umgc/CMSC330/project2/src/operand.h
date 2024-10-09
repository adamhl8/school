// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the definition of the Operand class, which is a subclass of Expression. It is an
// abstract class because it does not implement the evaluate function. It contains one static (class)
// function parse that parses an operand as either a literal or variable.

class Operand : public Expression
{
public:
  static Expression *parse(stringstream &in);
};
