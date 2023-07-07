package com.atividade.gerenciador;

import java.util.List;

import com.atividade.candidato.Candidato;
import com.atividade.exceptions.CandidadoNaoEncontrado;
import com.atividade.exceptions.CandidatoJaParticipa;
import com.atividade.exceptions.CandidatoNomeInvalido;

public interface IGerenciadorDeCandidatos {

    public int gerarIdSequencial();

    public int adicionarCandidato(String nome) throws CandidatoJaParticipa, CandidatoNomeInvalido;

    public Candidato buscarCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public List<String> obterAprovados();
}
