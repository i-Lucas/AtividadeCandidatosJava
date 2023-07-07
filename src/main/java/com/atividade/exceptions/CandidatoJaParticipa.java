package com.atividade.exceptions;

public class CandidatoJaParticipa extends Exception {
    public CandidatoJaParticipa(String nomeCandidato) {
        super(String.format("Candidato %s já participa do processo", nomeCandidato));
    }
}