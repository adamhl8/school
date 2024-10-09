// Adam Langbert
// Oct 8, 2024
// CMSC 330 - Advanced Programming Languages
// Project 2

// This file contains the body of the function parseName. That function consumes all alphanumeric
// characters until the next whitespace and returns the name that those characters form. It also
// includes error checking to ensure variable names start with a letter.

#include <cctype>
#include <sstream>
#include <string>
using namespace std;

#include "parse.h"

string parseName(stringstream &in)
{
  char c;
  string name = "";

  in >> ws;

  if (isalpha(in.peek()))
  {
    in >> c;
    name += c;
    while (isalnum(in.peek()) || in.peek() == '_')
    {
      in >> c;
      name += c;
    }
  }
  else
  {
    throw runtime_error("Variable names must start with a letter");
  }
  return name;
}
