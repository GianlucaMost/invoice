package logic;

import javax.swing.DefaultListModel;

public interface AusgabeBeobachter {

	public void print(String[] daten, DefaultListModel<String> ausgewaehlte);
}
