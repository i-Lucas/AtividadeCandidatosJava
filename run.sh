#!/bin/bash

if ! command -v mvn &> /dev/null; then
  echo "Erro: Maven não encontrado. Certifique-se de ter o Maven instalado no seu sistema."
  exit 1
fi

if [ "$1" = "-test" ]; then
  mvn test
else
  rm -rf target
  mvn package
   java -cp target/classes com.atividade.Main
fi
