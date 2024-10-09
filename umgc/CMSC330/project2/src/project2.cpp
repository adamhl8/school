// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the main function for the project 2 skeleton. It reads an input file named input.txt
// that contains one statement that includes an expression following by a sequence of variable assignments.
// It parses each statement and then evaluates it.

#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
using namespace std;

#include "expression.h"
#include "subexpression.h"
#include "symboltable.h"
#include "parse.h"

#ifdef _WIN32
#define PAUSE system("pause")
#else
#define PAUSE ((void)0)
#endif

SymbolTable symbolTable;

void parseAssignments(stringstream &in);

int main()
{
  const int SIZE = 256;
  Expression *expression;
  char paren, comma, line[SIZE];

  ifstream fin;
  fin = ifstream("input.txt");
  if (!(fin.is_open()))
  {
    cout << "File did not open" << endl;
    PAUSE;
    return 1;
  }
  while (true)
  {
    fin.getline(line, SIZE);
    if (!fin)
      break;
    symbolTable.clear(); // Reset symbol table
    stringstream in(line, ios_base::in);
    in >> paren;
    cout << line << endl;
    try
    {
      expression = SubExpression::parse(in);
      in >> comma;
      parseAssignments(in);
      if (expression == nullptr)
      {
        throw std::runtime_error("Expression is null after parsing");
      }
      double result = expression->evaluate();
      cout << "Value = " << result << endl
           << endl;
    }
    catch (const std::exception &e)
    {
      cout << "Error: " << e.what() << endl
           << endl;
    }
    catch (const string &message)
    {
      cout << message << endl
           << endl;
    }
    catch (...)
    {
      cout << "An unknown error occurred" << endl
           << endl;
    }
  }
  PAUSE;
  return 0;
}

void parseAssignments(stringstream &in)
{
  char assignop, delimiter;
  string variable;
  double value;
  do
  {
    variable = parseName(in);
    in >> ws >> assignop >> value >> delimiter;

    if (symbolTable.isDeclared(variable))
    {
      throw runtime_error("Variable '" + variable + "' is assigned more than once");
    }

    symbolTable.insert(variable, value);
  } while (delimiter == ',');
}
