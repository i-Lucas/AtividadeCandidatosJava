package com.atividade.gerenciador;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.atividade.candidato.Candidato;
import com.atividade.etapas.EtapasCandidato;
import com.atividade.exceptions.CandidatoJaParticipa;
import com.atividade.exceptions.CandidatoNomeInvalido;
import com.atividade.exceptions.CandidadoNaoEncontrado;

public class GerenciadorDeCandidatos implements IGerenciadorDeCandidatos {

    private HashMap<Integer, Candidato> listaCandidatos;
    private List<String> listaAprovados = new ArrayList<>();
    private int idSequencial;

    public GerenciadorDeCandidatos() {
        this.listaCandidatos = new HashMap<>();
        this.idSequencial = 0;
    }

    @Override
    public int gerarIdSequencial() {
        return ++this.idSequencial;
    }

    @Override
    public int adicionarCandidato(String nome) throws CandidatoJaParticipa, CandidatoNomeInvalido {

        try {

            this.validarCandidato(nome);
            return this.colocarNaLista(nome);

        } catch (CandidatoJaParticipa e) {
            throw e;
        }
    }

    @Override
    public Candidato buscarCandidato(int codCandidato) throws CandidadoNaoEncontrado {

        if (!listaCandidatos.containsKey(codCandidato)) {
            throw new CandidadoNaoEncontrado();
        }

        return listaCandidatos.get(codCandidato);
    }

    @Override
    public List<String> obterAprovados() {

        listaAprovados.clear();

        for (Candidato candidato : listaCandidatos.values()) {
            if (candidato.getStatus().equals(EtapasCandidato.Aprovado)) {
                listaAprovados.add(candidato.getNome());
            }
        }

        return listaAprovados;
    }

    private void validarCandidato(String nome) throws CandidatoJaParticipa, CandidatoNomeInvalido {

        if (!nome.matches("^(?!\\s*$).+")) {
            throw new CandidatoNomeInvalido();
        }

        for (Candidato candidato : listaCandidatos.values()) {
            if (candidato.getNome().equals(nome)) {
                throw new CandidatoJaParticipa(candidato.getNome());
            }
        }
    }

    private int colocarNaLista(String nome) {

        int id = gerarIdSequencial();
        listaCandidatos.put(id, new Candidato(nome));
        return id;
    }

}
