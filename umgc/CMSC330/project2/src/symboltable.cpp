// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the body of the functions contained in The SymbolTable class. The insert function
// inserts a new variable symbol and its value into the symbol table and the lookUp function returns
// that value of the supplied variable symbol name.

#include <string>
#include <vector>
using namespace std;

#include "symboltable.h"

void SymbolTable::insert(string variable, double value)
{
  const Symbol &symbol = Symbol(variable, value);
  elements.push_back(symbol);
}

double SymbolTable::lookUp(string variable) const
{
  for (int i = 0; i < elements.size(); i++)
    if (elements[i].variable == variable)
      return elements[i].value;
  return -1;
}

void SymbolTable::clear()
{
  elements.clear();
}

bool SymbolTable::isDeclared(string variable) const
{
  for (const Symbol &symbol : elements)
  {
    if (symbol.variable == variable)
      return true;
  }
  return false;
}
