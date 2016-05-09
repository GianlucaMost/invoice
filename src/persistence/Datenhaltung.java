package persistence;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import logic.Auto;
import logic.Autos;
import logic.Ersatzteil;
import logic.Ersatzteile;
import logic.Kunde;
import logic.Kunden;

public class Datenhaltung {
	static File fileKunden = new File( "/Users/fabianspruch/fileKunden.xml");
	static File fileAutos = new File( "/Users/fabianspruch/fileAutos.xml");
	static File fileErstzteile = new File( "/Users/fabianspruch/fileErsatzteile.xml");
	static Kunde kunde1 = new Kunde("Mustermann", "Max", 123, "Musterstr.");
	static Kunde kunde2 = new Kunde("Musterfrau", "Andrea", 124, "Musterstr.");
	static Kunde kunde3 = new Kunde("Müller", "Klaus", 125, "Musterweg");
	static Auto car1 = new Auto("DO-XX 1111", "123456789", "Ford", "Focus", kunde1);
	static Auto car2 = new Auto("BO-VV 2222", "123455344", "Volkswagen", "Golf", kunde2);
	static Auto car3 = new Auto("DD-GH 3333", "344984045", "Benz", "C-Klasse", kunde2);
	static Auto car4 = new Auto("RE-ZZ 4444", "98494348", "Audi", "A3", kunde3);
	static Ersatzteil erstatzteil1 = new Ersatzteil(null, 123, "Motor", 1456.79f, 1);
	static Ersatzteil erstatzteil2 = new Ersatzteil(null, 124, "Tür", 500.0f, 1);
	static Ersatzteil erstatzteil3 = new Ersatzteil(null, 125, "Fester", 600.90f, 1);
	
	
	static Kunden kunden = new Kunden();
	static Autos autos = new Autos();
	public static void erstellen() throws JAXBException {
				//Kunden einfügen
				Kunden kunden = new Kunden();
				kunden.setKunde(Arrays.asList(kunde1, kunde2, kunde3));
				JAXBContext context = JAXBContext.newInstance(Kunden.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				m.marshal(kunden, fileKunden);

				//Autos einfügen
				Autos autos = new Autos();
				autos.setAuto(Arrays.asList(car1, car2, car3, car4));
				JAXBContext contextCar = JAXBContext.newInstance(Autos.class);
				Marshaller mCar = contextCar.createMarshaller();
				mCar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				mCar.marshal(autos, fileAutos);
				
				//Ersatzteile einfügen
				Ersatzteile ersatzteile = new Ersatzteile();
				ersatzteile.setErsatzteil(Arrays.asList(erstatzteil1, erstatzteil2, erstatzteil3));
				JAXBContext contextErsatz = JAXBContext.newInstance(Ersatzteile.class);
				Marshaller mErsatz = contextErsatz.createMarshaller();
				mErsatz.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				
				mErsatz.marshal(ersatzteile, fileErstzteile);
	}
	
	
	public static String[] kundenAuslesen(int kundennummer){
		String name = null;
		String vorname = null;
		String adresse = null;
		try {	
	         
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(fileKunden);
	         doc.getDocumentElement().normalize();
	         NodeList kundenList = doc.getElementsByTagName("kunde");
	         for (int temp = 0; temp < kundenList.getLength(); temp++) {
	     		Node nNode = kundenList.item(temp);	
	     		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

	     			Element eElement = (Element) nNode;
	     			if (eElement.getElementsByTagName("kundennr").item(0).getTextContent().contains(Integer.toString(kundennummer))){
	     				name = eElement.getElementsByTagName("name").item(0).getTextContent();
		     			vorname = eElement.getElementsByTagName("vorname").item(0).getTextContent();
		     			adresse = eElement.getElementsByTagName("adresse").item(0).getTextContent();
	     			}
	     		}
	     	}
	         String ausgabe[] = new String[3];
	         ausgabe[0] = name;
	         ausgabe[1] = vorname;
	         ausgabe[2] = adresse;
	         return(ausgabe);
	     } catch (Exception e) {
	         e.printStackTrace();
	      }
		return null;
	}
	
	public static String[] kundenNummernAuslesen(){
		
		
		try {
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fileKunden);
        doc.getDocumentElement().normalize();
        NodeList kundenList = doc.getElementsByTagName("kunde");
        String kundenNummern[] = new String[kundenList.getLength()];
        for (int temp = 0; temp < kundenList.getLength(); temp++) {
    		Node nNode = kundenList.item(temp);	
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    			Element eElement = (Element) nNode;
    			String kundennr =eElement.getElementsByTagName("kundennr").item(0).getTextContent();
    			kundenNummern[temp]=kundennr;
    		}
    	}

		return (kundenNummern);
    } catch (Exception e) {
        e.printStackTrace();
     }
		return null;
	}
	
public static String[] ErstazteileAuslesen(){
		
		
		try {
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fileErstzteile);
        doc.getDocumentElement().normalize();
        NodeList ersatzteileList = doc.getElementsByTagName("ersatzteil");
        String Ersatzteile[] = new String[ersatzteileList.getLength()];
        for (int temp = 0; temp < ersatzteileList.getLength(); temp++) {
    		Node nNode = ersatzteileList.item(temp);	
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    			Element eElement = (Element) nNode;
    			String bezeichnung =eElement.getElementsByTagName("bezeichnung").item(0).getTextContent();
    			Ersatzteile[temp]=bezeichnung;
    		}
    	}

		return (Ersatzteile);
    } catch (Exception e) {
        e.printStackTrace();
     }
		return null;
	}

}
