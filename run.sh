#!/bin/bash

if [ "$1" = "-test" ]; then
  mvn test
else
  rm -rf target
  mvn package
   java -cp target/classes com.atividade.Main
fi
