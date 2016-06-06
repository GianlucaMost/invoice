package logic;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;


/**
 * Created by gianlucamost on 02.05.16.
 */
public class Rechnung implements AusgabeBeobachter {
    private String schaden;
    private List<Rechnungsposition> rechnungspositionList;
    private static List<AusgabeBeobachter> alleBeobachter = new ArrayList<>();
	private String[] daten;
	private DefaultListModel<String> ausgewaehlte;
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
    
    static public void anmelden(AusgabeBeobachter beobachter){
    	alleBeobachter.add(beobachter);
    	}
    static public void abmelden(AusgabeBeobachter beobachter){
    	alleBeobachter.remove(beobachter);
    	}
    public void print(String[] daten, DefaultListModel<String> ausgewaehlte, DefaultListModel<String> ausgewaehltesAuto) { 
    	this.daten = daten;
    	this.ausgewaehlte = ausgewaehlte;
    	informiereBeobachter();
    }
    public void informiereBeobachter(){
    	for (AusgabeBeobachter beobachter : alleBeobachter){
    		beobachter.print(daten, ausgewaehlte);
    	}
    }
}
