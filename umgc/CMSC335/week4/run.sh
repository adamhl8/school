#!/bin/sh

rm -rf ./bin
javac -d ./bin ./Main.java
java -cp ./bin Main
