#!/bin/bash

echo "Enter a number : "
read n

isPrime=1

for (( i = 2; i < $n; i++ )); do
	if [ $(( $n % $i )) == 0 ]; then
		isPrime=0
		break
	fi
done

if [ $isPrime == 1 ]; then
	echo "$n is a prime number"
else
	echo "$n is not a prime number"
fi
