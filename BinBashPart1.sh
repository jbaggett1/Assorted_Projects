#!/bin/bash

echo "This line goes to terminal window"

echo "This line goes to doggo.txt" >> doggo.txt
echo "The first parameter was ${1}, the second ${2}, the third ${3}, the fourth ${4}"
x=${1}
y=${2}
z=${3}
w=${4}
p=${5} #takes in file 
q=${6} #takes in folder 

echo "$y"


if [[ ${1} -gt ${2} ]]; then
echo "${1} is greater than ${2}"
else
echo "${1} is less than or equal to ${2}"
fi

echo "${5}"
echo "${6}"
#assuming first is a file and second is a folder
if [ -d ${6} ]
then
    echo "This (${6}) folder exists"
else
    echo "This (${6}) folder does not exist"
fi


if [ -e ${5} ]
then
    echo "This (${5}) file exists"
else
	if [ -e "${6}/${5}" ]
	then
		echo "This (${5}) file exists"
	else 	
    echo "This (${5}) file does not exist"
	fi
fi

if [ $(find "${6}" -name "${5}") ]; then 
  echo "$5 is found in $6"
else
  echo "$5 not found in $6"
fi

cd "${6}"
for file in *.txt; do
	echo "$file"
done
exit
