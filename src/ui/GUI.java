package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextField;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;


public class GUI{

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

				System.out.println("Button neue Rechung wurde gedr�ckt");
			}
		});
		btnNeueRechung.setBounds(238, 443, 170, 29);
		hauptFrame.getContentPane().add(btnNeueRechung);

		JButton hinzufuegenBT = new JButton("hinzufügen");
		hinzufuegenBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("hinzuf�gen");
			}
		});
		hinzufuegenBT.setBounds(266, 62, 203, 29);
		hauptFrame.getContentPane().add(hinzufuegenBT);


		//Infos Kunde
		JButton rechungErstellenBT = new JButton("Rechung erstellen");
		rechungErstellenBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logic.Rechnung rechnung = new logic.Rechnung();
				JOptionPane.showMessageDialog(null,"Rechnung erstellt!");
			}
		});
		rechungErstellenBT.setBounds(68, 443, 170, 29);
		hauptFrame.getContentPane().add(rechungErstellenBT);


		JLabel kundennummerLB = new JLabel("Kundennummer:");
		kundennummerLB.setBounds(6, 17, 114, 16);
		hauptFrame.getContentPane().add(kundennummerLB);
		String Liste[] = {"00001" ,"00002", "00003"};
		JComboBox kundennummerCB = new JComboBox(Liste);
		kundennummerCB.setSelectedIndex(-1);
		kundennummerCB.setBounds(6, 36, 170, 27);
		hauptFrame.getContentPane().add(kundennummerCB);
		kundennummerCB.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				System.out.println("Test");
			}
		});

		JLabel nameLB = new JLabel("Name:");
		nameLB.setBounds(6, 67, 61, 16);
		hauptFrame.getContentPane().add(nameLB);

		JTextField nameTF = new JTextField();
		nameTF.setBounds(6, 88, 170, 26);
		hauptFrame.getContentPane().add(nameTF);
		nameTF.setColumns(10);

		JLabel vornameLB = new JLabel("Vorname:");
		vornameLB.setBounds(6, 118, 61, 16);
		hauptFrame.getContentPane().add(vornameLB);

		JTextField vornameTF = new JTextField();
		vornameTF.setBounds(6, 136, 170, 26);
		hauptFrame.getContentPane().add(vornameTF);
		vornameTF.setColumns(10);

		JLabel adresseLB = new JLabel("Adresse:");
		adresseLB.setBounds(6, 166, 61, 16);
		hauptFrame.getContentPane().add(adresseLB);

		JTextField adresseTF = new JTextField();
		adresseTF.setColumns(10);
		adresseTF.setBounds(6, 186, 170, 26);
		hauptFrame.getContentPane().add(adresseTF);



		//zubrechnene Punkte

		JComboBox kostenpunkteCB = new JComboBox();
		kostenpunkteCB.setBounds(268, 36, 201, 27);
		hauptFrame.getContentPane().add(kostenpunkteCB);

		JLabel kostenpunkteLB = new JLabel("Kostenpunkte:");
		kostenpunkteLB.setBounds(270, 17, 101, 16);
		hauptFrame.getContentPane().add(kostenpunkteLB);

		JTextPane kostenpunkteTB = new JTextPane();
		kostenpunkteTB.setBounds(276, 103, 190, 236);
		hauptFrame.getContentPane().add(kostenpunkteTB);


		hauptFrame.setVisible(true);


	}
}
