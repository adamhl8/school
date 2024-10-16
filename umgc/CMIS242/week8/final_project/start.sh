#!/bin/sh

javac ./src/MediaRentalSystem.java
java src.MediaRentalSystem

find ./src -type f -name "*.class" -exec rm -f {} \;
