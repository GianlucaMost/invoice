package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Auto {

    private String kennzeichen;
    private String fahrgestellnr;
    private String marke;
    private String typ;
    private Kunde kunde;

    public Auto(String kennzeichen, String fahrgestellnr, String marke, String typ, Kunde kunde) {
        this.kennzeichen = kennzeichen;
        this.fahrgestellnr = fahrgestellnr;
        this.marke = marke;
        this.typ = typ;
        this.kunde = kunde;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getFahrgestellnr() {
        return fahrgestellnr;
    }

    public void setFahrgestellnr(String fahrgestellnr) {
        this.fahrgestellnr = fahrgestellnr;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}
