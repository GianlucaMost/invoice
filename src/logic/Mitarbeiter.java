package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public abstract class Mitarbeiter extends Mensch {

    private int mitarbeiternr;

    public Mitarbeiter(int mitarbeiternr, String vorname, String nachname) {
        super(vorname, nachname);
        this.mitarbeiternr = mitarbeiternr;
    }

    public int getMitarbeiternr() {
        return mitarbeiternr;
    }

    public void setMitarbeiternr(int mitarbeiternr) {
        this.mitarbeiternr = mitarbeiternr;
    }
}
