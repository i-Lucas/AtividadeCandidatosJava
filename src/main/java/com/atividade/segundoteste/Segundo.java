package com.atividade.segundoteste;

import java.util.List;

import com.atividade.candidato.Candidato;
import com.atividade.etapas.EtapasCandidato;
import com.atividade.exceptions.CandidatoJaParticipa;
import com.atividade.exceptions.CandidatoNomeInvalido;
import com.atividade.exceptions.CandidadoNaoEncontrado;
import com.atividade.exceptions.CandidatoDesqualificado;
import com.atividade.gerenciador.GerenciadorDeCandidatos;

public class Segundo implements ISegundo {

    private final GerenciadorDeCandidatos gerenciador;

    public Segundo() {
        this.gerenciador = new GerenciadorDeCandidatos();
    }

    @Override
    public int iniciarProcesso(String nome) throws CandidatoJaParticipa, CandidatoNomeInvalido {
        return gerenciador.adicionarCandidato(nome);
    }

    @Override
    public void marcarEntrevista(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        candidato.setStatus(EtapasCandidato.Qualificado);
    }

    @Override
    public void desqualificarCandidato(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        candidato.setStatus(EtapasCandidato.Desqualificado);
    }

    @Override
    public String verificarStatusCandidato(int codCandidato) throws CandidadoNaoEncontrado, CandidatoDesqualificado {

        Candidato candidato = gerenciador.buscarCandidato(codCandidato);

        if (candidato.getStatus().equals(EtapasCandidato.Desqualificado)) {
            throw new CandidatoDesqualificado("Este candidato foi desqualificado");
        }

        return candidato.imprimirStatus();
    }

    @Override
    public void aprovarCandidato(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        candidato.setStatus(EtapasCandidato.Aprovado);
    }

    @Override
    public List<String> obterAprovados() {
        return gerenciador.obterAprovados();
    }
}
