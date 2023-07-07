package segundoteste;

import java.util.List;

import candidato.Candidato;
import etapas.EtapasCandidato;
import exceptions.CandidatoJaParticipa;
import exceptions.CandidadoNaoEncontrado;
import gerenciador.GerenciadorDeCandidatos;

public class Segundo implements ISegundo {

    private GerenciadorDeCandidatos gerenciador;

    public Segundo() {
        this.gerenciador = new GerenciadorDeCandidatos();
    }

    @Override
    public int iniciarProcesso(String nome) throws CandidatoJaParticipa {
        return gerenciador.adicionarCandidato(nome);
    }

    @Override
    public void marcarEntrevista(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        candidato.setStatus(EtapasCandidato.QUALIFICADO);
    }

    @Override
    public void desqualificarCandidato(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        candidato.setStatus(EtapasCandidato.DESQUALIFICADO);
    }

    @Override
    public String verificarStatusCandidato(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        return candidato.imprimirStatus();
    }

    @Override
    public void aprovarCandidato(int codCandidato) throws CandidadoNaoEncontrado {
        Candidato candidato = gerenciador.buscarCandidato(codCandidato);
        candidato.setStatus(EtapasCandidato.APROVADO);
    }

    @Override
    public List<String> obterAprovados() {
        return gerenciador.obterAprovados();
    }
}
