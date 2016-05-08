package persistence;

import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import logic.Auto;
import logic.Autos;
import logic.Kunde;
import logic.Kunden;

public class Datenhaltung {

	static Kunde kunde1 = new Kunde("Mustermann", "Max", 123, "Musterstr.");
	static Kunde kunde2 = new Kunde("Musterfrau", "Andrea", 124, "Musterstr.");
	static Kunde kunde3 = new Kunde("Müller", "Klaus", 125, "Musterweg");
	static Auto car1 = new Auto("DO-XX 1111", "123456789", "Ford", "Focus", kunde1);
	static Auto car2 = new Auto("BO-VV 2222", "123455344", "Volkswagen", "Golf", kunde2);
	static Auto car3 = new Auto("DD-GH 3333", "344984045", "Benz", "C-Klasse", kunde2);
	static Auto car4 = new Auto("RE-ZZ 4444", "98494348", "Audi", "A3", kunde3);
	
	static Kunden kunden = new Kunden();
	static Autos autos = new Autos();
	public static void erstellen() throws JAXBException {
				//Kunden einfügen
				Kunden kunden = new Kunden();
				kunden.setKunde(Arrays.asList(kunde1, kunde2, kunde3));
				JAXBContext context = JAXBContext.newInstance(Kunden.class);
				Marshaller m = context.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(kunden, System.out);

				//Autos einfügen
				Autos autos = new Autos();
				autos.setAuto(Arrays.asList(car1, car2, car3, car4));
				JAXBContext contextCar = JAXBContext.newInstance(Autos.class);
				Marshaller mCar = contextCar.createMarshaller();
				mCar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				mCar.marshal(autos, System.out);
	}

}
