package logic;

import javax.swing.DefaultListModel;

public class Drucker implements AusgabeBeobachter {

	@Override
	public void print(String[] daten, DefaultListModel<String> ausgewaehlte) {
		System.out.println("Druck erfolgt.");

	}

}
