package com.atividade.segundoteste;

import java.util.List;

import com.atividade.exceptions.CandidatoJaParticipa;
import com.atividade.exceptions.CandidatoNomeInvalido;
import com.atividade.exceptions.CandidadoNaoEncontrado;
import com.atividade.exceptions.CandidatoDesqualificado;

public interface ISegundo {

    public int iniciarProcesso(String nome) throws CandidatoJaParticipa, CandidatoNomeInvalido;

    public void marcarEntrevista(int codCandidato) throws CandidadoNaoEncontrado;

    public void desqualificarCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public String verificarStatusCandidato(int codCandidato) throws CandidadoNaoEncontrado, CandidatoDesqualificado;

    public void aprovarCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public List<String> obterAprovados();
}
