package com.atividade.exceptions;

public class CandidatoNomeInvalido extends Exception {
    public CandidatoNomeInvalido() {
        super("O nome do candidato contém caracteres inválidos.");
    }
}