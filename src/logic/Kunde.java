package logic;

import java.util.List;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Kunde extends Mensch implements KundeInterface {

    private int kundennr;
    private String adresse;
    private List <Auto> autoList;

    public Kunde(String name, String vorname, int kundennr, String adresse, List<Auto> autoList) {
        super(name, vorname);
        this.kundennr = kundennr;
        this.adresse = adresse;
        this.autoList = autoList;
    }

    public Kunde(String name, String vorname, int kundennr, String adresse) {
        super(name, vorname);
        this.kundennr = kundennr;
        this.adresse = adresse;
    }

    public int getKundennr() {
        return kundennr;
    }

    public void setKundennr(int kundennr) {
        this.kundennr = kundennr;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Auto> getAutoList() {
        return autoList;
    }

    public void setAutoList(List<Auto> autoList) {
        this.autoList = autoList;
    }

    public void addAuto(Auto car) {
        this.autoList.add(car);
    }
}
