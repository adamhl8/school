@echo off

rmdir /s /q .\bin
mkdir .\bin
javac --module-path lib --add-modules javafx.graphics,javafx.controls -d .\bin .\src\Main.java
java --module-path lib --add-modules javafx.graphics,javafx.controls -cp .\bin src.Main
