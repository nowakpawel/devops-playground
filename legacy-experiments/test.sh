#!/bin/bash
set -e

#Compile the program
gcc -o app ./legacy-experiments/main.c

#Run it and check if output contains "Integer types"

echo "Testuser" | ./app | grep "Integer types"

echo "✅Test passed: Output looks ok"
