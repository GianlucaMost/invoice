package logic;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.text.Document;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;


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

    public void print(String[] daten) { 
    	PrintWriter pWriter = null; 
        try {   	
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("/Users/fabianspruch/bezeichung"+ LocalDateTime.now() +".txt"))); 
            for (int i = 0; i<daten.length; i++){
            	pWriter.println(daten[i]);
            	
            }
            JOptionPane.showMessageDialog(null,"Rechnung erstellt!");
        } catch (IOException ioe) { 
        	JOptionPane.showMessageDialog(null,"Rechnung nicht erstellt!");
        } finally { 
            if (pWriter != null){ 
                pWriter.flush(); 
                pWriter.close(); 
            } 
        } 
    }
}
