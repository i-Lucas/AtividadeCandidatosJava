package com.atividade.candidato;

import com.atividade.etapas.EtapasCandidato;

public class Candidato implements ICandidato {

    private String nome;
    private EtapasCandidato status;

    public Candidato(String nome) {
        this.nome = nome;
        this.status = EtapasCandidato.Recebido;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public EtapasCandidato getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(EtapasCandidato status) {
        this.status = status;
    }

    @Override
    public String imprimirStatus() {
        return this.getStatus().toString();
    }

}
