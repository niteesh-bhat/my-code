#!/bin/bash

echo "Enter number of elements: "
read n

echo "Enter the elements :"
for ((i = 0; i < $n; i++)); do
	read A[$i]
done

echo "Elements of the array are : "
for ((i = 0; i < $n; i++)); do
	echo ${A[$i]}
done

max=${A[0]}
for ((i = 0; i < $n; i++)); do 
	if [ ${A[$i]} -gt $max ]; then
		max=${A[$i]}
	fi
done

echo "The largest element is : $max"
