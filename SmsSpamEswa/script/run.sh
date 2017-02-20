#!/bin/sh

for i in `seq 1 3`
do
  DATE=`date +%Y-%m-%d_%H:%M:%S`;
  FILE="SmsProcessor_$DATE.log";
  java -Xmx8G -jar SmsProcessor.jar > $FILE;
  sleep 1;
done
