package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Zeitaufwand extends Rechnungsposition{

    private float std;
    private String beschreibung;
    private Mechaniker mechaniker;

    public Zeitaufwand(Rechnung rechnung, float std, String beschreibung, Mechaniker mechaniker) {
        super(rechnung);
        this.std = std;
        this.beschreibung = beschreibung;
        this.mechaniker = mechaniker;
    }

    public float getStd() {
        return std;
    }

    public void setStd(float std) {
        this.std = std;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Mechaniker getMechaniker() {
        return mechaniker;
    }

    public void setMechaniker(Mechaniker mechaniker) {
        this.mechaniker = mechaniker;
    }
}
