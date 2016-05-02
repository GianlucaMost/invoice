package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Ersatzteil extends Rechnungsposition {
    private int nummer;
    private String bezeichnung;
    private float preis;
    private int anzahl;

    public Ersatzteil(Rechnung rechnung, int nummer, String bezeichnung, float preis, int anzahl) {
        super(rechnung);
        this.nummer = nummer;
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.anzahl = anzahl;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public Rechnung getRechnung(Rechnung rechnung) {
        return super.getRechnung();
    }

    public void setRechnung(Rechnung rechnung) {
        super.setRechnung(rechnung);
    }

}
