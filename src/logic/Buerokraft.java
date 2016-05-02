package logic;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Buerokraft extends Mitarbeiter {

    private String telnr;

    public Buerokraft(String vorname, String nachname, int mitarbeiternr, String telnr) {
        super(mitarbeiternr, vorname, nachname);
        this.telnr = telnr;
    }

    public String getTelnr() {
        return telnr;
    }

    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }
}
