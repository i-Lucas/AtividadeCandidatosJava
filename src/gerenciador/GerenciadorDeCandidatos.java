package gerenciador;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import candidato.Candidato;
import etapas.EtapasCandidato;
import exceptions.CandidatoJaParticipa;
import exceptions.CandidadoNaoEncontrado;

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
    public int adicionarCandidato(String nome) throws CandidatoJaParticipa {

        try {

            this.verificarCandidato(nome);
            return this.colocarNaLista(nome);

        } catch (CandidatoJaParticipa e) {
            throw e;
        }
    }

    @Override
    public Candidato buscarCandidato(int codCandidato) throws CandidadoNaoEncontrado {

        if (!listaCandidatos.containsKey(codCandidato)) {
            throw new CandidadoNaoEncontrado("Candidato não encontrado");
        }

        return listaCandidatos.get(codCandidato);
    }

    @Override
    public void verificarCandidato(String nome) throws CandidatoJaParticipa {

        for (Candidato candidato : listaCandidatos.values()) {
            if (candidato.getNome().equals(nome)) {
                throw new CandidatoJaParticipa(candidato.getNome());
            }
        }
    }

    @Override
    public List<String> obterAprovados() {

        for (Candidato candidato : listaCandidatos.values()) {
            if (candidato.getStatus().equals(EtapasCandidato.APROVADO)) {
                listaAprovados.add(candidato.getNome());
            }
        }

        return listaAprovados;
    }

    private int colocarNaLista(String nome) {
        int id = gerarIdSequencial();
        listaCandidatos.put(id, new Candidato(nome));
        return id;
    }

}
