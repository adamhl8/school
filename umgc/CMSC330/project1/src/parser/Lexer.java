package src.parser;

import java.io.*;

/**
 * @author Adam Langbert
 * @date Sep 10, 2024
 * @course CMSC 330 - Advanced Programming Languages
 * @assignment Project 1
 * @description Class Lexer: Lexical analyzer that converts the input stream into tokens.
 * @java-version Java 17
 */

class Lexer {

  private StreamTokenizer tokenizer;
  final private char quoteChar = '"';
  final private String punctuation = ",;.()";
  final private Token[] punctuationTokens =
      {Token.COMMA, Token.SEMICOLON, Token.PERIOD, Token.LEFT_PAREN, Token.RIGHT_PAREN};

  // Constructor that creates a lexical analyzer object given the source file

  public Lexer(File file) throws FileNotFoundException {
    tokenizer = new StreamTokenizer(new FileReader(file));
    tokenizer.ordinaryChar('.');
    tokenizer.quoteChar(quoteChar);
  }

  // Returns the next token in the input stream

  public Token getNextToken() throws LexicalError, IOException {
    int token = tokenizer.nextToken();
    switch (token) {
      case StreamTokenizer.TT_NUMBER:
        return Token.NUMBER;
      case StreamTokenizer.TT_WORD:
        for (Token aToken : Token.values())
          if (aToken.name().replace("_", "").equals(tokenizer.sval.toUpperCase()))
            return aToken;
        return Token.IDENTIFIER;
      case quoteChar:
        return Token.STRING;
      case StreamTokenizer.TT_EOF:
        return Token.EOF;
      default:
        for (int i = 0; i < punctuation.length(); i++)
          if (token == punctuation.charAt(i))
            return punctuationTokens[i];
    }
    return Token.EOF;
  }

  // Returns the lexeme associated with the current token

  public String getLexeme() {
    return tokenizer.sval;
  }

  // Returns the numeric value of the current token for numeric tokens

  public int getNumber() {
    return (int) tokenizer.nval;
  }

  // Returns the current line of the input file

  public int getLineNo() {
    return tokenizer.lineno();
  }

  // Returns the string associated with the current token

  public String getString() {
    return tokenizer.sval;
  }
}
