#!/bin/sh

rm -rf ./bin
mkdir -p ./bin
cp -r ./src/images ./bin/images
javac --module-path lib --add-modules javafx.graphics,javafx.controls -d ./bin ./src/Main.java
java --module-path lib --add-modules javafx.graphics,javafx.controls -cp ./bin src.Main
