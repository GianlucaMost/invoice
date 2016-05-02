package logic;

import java.util.List;

/**
 * Created by gianlucamost on 02.05.16.
 */
public class Rechnung {
    private String schaden;
    private List<Rechnungsposition> rechnungspositionList;

    public Rechnung() {
    }

    public Rechnung(String schaden, List<Rechnungsposition> rechnungspositionList) {
        this.schaden = schaden;
        this.rechnungspositionList = rechnungspositionList;
    }

    public String getSchaden() {
        return schaden;
    }

    public void setSchaden(String schaden) {
        this.schaden = schaden;
    }

    public List<Rechnungsposition> getRechnungspositionList() {
        return rechnungspositionList;
    }

    public void setRechnungspositionList(List<Rechnungsposition> rechnungspositionList) {
        this.rechnungspositionList = rechnungspositionList;
    }

    public void print() {
        //TODO Implementieren
    }
}
