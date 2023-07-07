import exceptions.CandidadoNaoEncontrado;
import exceptions.CandidatoJaParticipa;
import segundoteste.Segundo;

public class Main {

    public static void main(String[] args) {

        Segundo processo = new Segundo();
        System.out.println("\nLista dos aprovados: " + processo.obterAprovados());

        try {

            processo.iniciarProcesso("Fulano");
            processo.iniciarProcesso("Lucas");

        } catch (CandidatoJaParticipa error) {

            System.out.println("\n" + error + "\n");
            error.printStackTrace();
        }

        try {

            System.out.println("\n" + processo.verificarStatusCandidato(1));
            processo.marcarEntrevista(1);
            System.out.println(processo.verificarStatusCandidato(1));
            processo.desqualificarCandidato(1);
            System.out.println(processo.verificarStatusCandidato(1));

            processo.marcarEntrevista(2);
            processo.aprovarCandidato(2);
            System.out.println("Lista dos aprovados: " + processo.obterAprovados());

        } catch (CandidadoNaoEncontrado error) {

            System.out.println("\n" + error + "\n");
            error.printStackTrace();
        }

        try {
            processo.iniciarProcesso("Lucas");

        } catch (CandidatoJaParticipa error) {
            System.out.println("\n" + error + "\n");
            error.printStackTrace();
        }

    }
}