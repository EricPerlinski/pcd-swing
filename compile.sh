#!/bin/sh

mkdir bin
cd src
javac main/Main.java compteur/*.java vue/*.java -d ../bin
