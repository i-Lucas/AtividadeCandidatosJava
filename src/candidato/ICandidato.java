package candidato;

import etapas.EtapasCandidato;

public interface ICandidato {

    public String getNome();

    public EtapasCandidato getStatus();

    public void setStatus(EtapasCandidato status);

    public String imprimirStatus();

}