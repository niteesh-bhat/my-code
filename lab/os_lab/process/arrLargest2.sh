#!/bin/bash

echo "Enter the elements :"
read -a A
n=${#A[@]}
echo "Length of the array is $n"

echo "Elements of the array are : "
for i in ${A[@]}; do
	echo $i
done

max=${A[0]}
for i in ${A[@]}; do
	if [ $i -gt $max ]; then
		max=$i
	fi
done

echo "The largest element is : $max"
