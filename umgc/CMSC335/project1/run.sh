#!/bin/sh

rm -rf ./bin
javac -d ./bin ./src/Main.java
java -cp ./bin src.Main
