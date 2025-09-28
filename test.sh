#!/bin/bash
set -e

#Compile the program
gcc -o app main.c

#Run it and check if output contains "Integer types"

./app | grep "Integer types"

echo "✅Test passed: Output looks ok"
