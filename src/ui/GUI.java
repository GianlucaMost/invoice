package ui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import persistence.Datenhaltung;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class GUI{
	JTextField nameTF = new JTextField();
	JTextField vornameTF = new JTextField();
	JTextField adresseTF = new JTextField();
	JComboBox kostenpunkteCB = new JComboBox(Datenhaltung.ErstazteileAuslesen());
	DefaultListModel<String> ausgewaehlte = new DefaultListModel<>();
	JList<String> ausgewählteLT = new JList<>(ausgewaehlte);
	String daten[] = null;

	
	public GUI(){
		erstellen();
	}
	private void erstellen(){
		//Hauptfenster erstellen

		JFrame hauptFrame = new JFrame();
		hauptFrame.setBounds(100, 100, 500, 544);
		hauptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hauptFrame.getContentPane().setLayout(null);
		
		//Erstellen Button hinzufügen
		JButton btnNeueRechung = new JButton("neue Rechung");
		btnNeueRechung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hauptFrame.dispose();
				ui.GUI gui = new GUI();

				
			}
		});
		btnNeueRechung.setBounds(238, 443, 170, 29);
		hauptFrame.getContentPane().add(btnNeueRechung);

		JButton hinzufuegenBT = new JButton("hinzufügen");
		hinzufuegenBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ausgewaehlte.addElement(kostenpunkteCB.getSelectedItem().toString());
				}catch(Exception e1){
					
				}
				
				
			}
		});
		hinzufuegenBT.setBounds(266, 62, 203, 29);
		hauptFrame.getContentPane().add(hinzufuegenBT);


		//Infos Kunde
		JButton rechungErstellenBT = new JButton("Rechung erstellen");
		rechungErstellenBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Rechnung rechnung = new logic.Rechnung();
				rechnung.print(daten);
				
			}
		});
		rechungErstellenBT.setBounds(68, 443, 170, 29);
		hauptFrame.getContentPane().add(rechungErstellenBT);
			

		JLabel kundennummerLB = new JLabel("Kundennummer:");
		kundennummerLB.setBounds(6, 17, 114, 16);
		hauptFrame.getContentPane().add(kundennummerLB);
	
		JComboBox kundennummerCB = new JComboBox(Datenhaltung.kundenNummernAuslesen());
		kundennummerCB.setSelectedIndex(-1);
		kundennummerCB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if (kundennummerCB.getSelectedItem() != null){
            	daten = Datenhaltung.kundenAuslesen(Integer.parseInt(kundennummerCB.getSelectedItem().toString()));
            	nameTF.setText(daten[0]);
            	vornameTF.setText(daten[1]);
            	adresseTF.setText(daten[2]);
            	}
            	
            }
        });

		kundennummerCB.setBounds(6, 36, 170, 27);
		hauptFrame.getContentPane().add(kundennummerCB);
		

		JLabel nameLB = new JLabel("Name:");
		nameLB.setBounds(6, 67, 61, 16);
		hauptFrame.getContentPane().add(nameLB);

		
		nameTF.setBounds(6, 88, 170, 26);
		hauptFrame.getContentPane().add(nameTF);
		nameTF.setColumns(10);

		JLabel vornameLB = new JLabel("Vorname:");
		vornameLB.setBounds(6, 118, 61, 16);
		hauptFrame.getContentPane().add(vornameLB);

		
		vornameTF.setBounds(6, 136, 170, 26);
		hauptFrame.getContentPane().add(vornameTF);
		vornameTF.setColumns(10);

		JLabel adresseLB = new JLabel("Adresse:");
		adresseLB.setBounds(6, 166, 61, 16);
		hauptFrame.getContentPane().add(adresseLB);

		
		adresseTF.setColumns(10);
		adresseTF.setBounds(6, 186, 170, 26);
		hauptFrame.getContentPane().add(adresseTF);



		//zubrechnene Punkte

		
		kostenpunkteCB.setSelectedIndex(-1);
		kostenpunkteCB.setBounds(268, 36, 201, 27);
		hauptFrame.getContentPane().add(kostenpunkteCB);


		JLabel kostenpunkteLB = new JLabel("Kostenpunkte:");
		kostenpunkteLB.setBounds(270, 17, 101, 16);
		
		JButton btnLschen = new JButton("löschen");
		btnLschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loeschen(ausgewaehlte, ausgewählteLT.getSelectedIndex());
			}
		});
		btnLschen.setBounds(311, 339, 117, 29);
		hauptFrame.getContentPane().add(btnLschen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 103, 203, 224);
		hauptFrame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(ausgewählteLT);
		
		ausgewählteLT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel autoLB = new JLabel("Auto:");
		autoLB.setBounds(6, 213, 61, 16);
		hauptFrame.getContentPane().add(autoLB);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 235, 176, 27);
		hauptFrame.getContentPane().add(comboBox);


		hauptFrame.setVisible(true);


	}
	public static void loeschen(DefaultListModel<String> liste, int zuloeschendesElement){
	try{
		liste.remove(zuloeschendesElement);
	 } catch (Exception e) {
         
      }
	}
}
