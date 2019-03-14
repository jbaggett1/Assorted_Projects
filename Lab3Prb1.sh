#!/bin/bash


date > results          # save the date to my results
for file in ‘ls *.jar 2> /dev/null‘; do  # for each file here named something.jar
  echo ${file}            # echo its name
  java -jar ${file} >> results # run the jar and save the results
done
exit