#!/bin/bash
set -e

#Compile the program
gcc -o app main.c

#Run it and checj if output contains "Integer types"

./app | grep "Integer types"

echo "✅Test passed: Output looks ok"
