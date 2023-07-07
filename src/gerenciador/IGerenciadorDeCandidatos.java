package gerenciador;

import java.util.List;

import exceptions.CandidatoJaParticipa;
import candidato.Candidato;
import exceptions.CandidadoNaoEncontrado;

public interface IGerenciadorDeCandidatos {

    public int gerarIdSequencial();

    public int adicionarCandidato(String nome) throws CandidatoJaParticipa;

    public Candidato buscarCandidato(int codCandidato) throws CandidadoNaoEncontrado;

    public void verificarCandidato(String nome) throws CandidatoJaParticipa;

    public List<String> obterAprovados();
}
