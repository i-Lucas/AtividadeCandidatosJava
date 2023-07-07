package segundoteste;

import java.util.List;

import exceptions.CandidadoNaoEncontrado;
import exceptions.CandidatoJaParticipa;

public interface ISegundo {

    public int iniciarProcesso(String nome) throws CandidatoJaParticipa;

    public void marcarEntrevista(int codCandidato) throws CandidadoNaoEncontrado;

    public void desqualificarCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public String verificarStatusCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public void aprovarCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public List<String> obterAprovados();
}
