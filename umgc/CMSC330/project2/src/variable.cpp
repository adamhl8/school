// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the body of the function contained in The Variable class. The evaluate function
// looks up te value of a variable in the symbol table and returns that value.

#include <string>
#include <vector>
using namespace std;

#include "expression.h"
#include "operand.h"
#include "variable.h"
#include "symboltable.h"

extern SymbolTable symbolTable;

double Variable::evaluate()
{
  if (!symbolTable.isDeclared(name))
  {
    throw runtime_error("Variable '" + name + "' is uninitialized");
  }
  return symbolTable.lookUp(name);
}
