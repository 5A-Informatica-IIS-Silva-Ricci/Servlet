import java.io.Serializable;

public class BeanNazione implements Serializable {
    private String nazione;
    private String sigla;

    public BeanNazione(String nazione, String sigla) {
        this.nazione = nazione;
        this.sigla = sigla;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
