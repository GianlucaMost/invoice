package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Mechaniker extends Mitarbeiter {

    private int stundenlohn;

    public Mechaniker(int mitarbeiternr, String vorname, String nachname, int stundenlohn) {
        super(mitarbeiternr, vorname, nachname);
        this.stundenlohn = stundenlohn;
    }

    public int getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(int stundenlohn) {
        this.stundenlohn = stundenlohn;
    }
}
