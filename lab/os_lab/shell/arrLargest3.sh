#!/bin/bash
echo "Command line arguments are : $@"
echo "Length : $#"

max=$1
for i in $@; do
	if [ $i -gt $max ]; then
		max=$i
	fi
done

echo "Largest element is : $max"
