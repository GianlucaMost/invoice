import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import logic.Auto;
import logic.Kunde;
import logic.Kunden;

public class Datenhaltung {

	static Kunde kunde1 = new Kunde("Mustermann", "Max", 123, "Musterstr.");
	static Kunde kunde2 = new Kunde("Musterfrau", "Andrea", 124, "Musterstr.");
	static Kunde kunde3 = new Kunde("Müller", "Klaus", 125, "Musterweg");
	Auto car = new Auto("DO-XX 1111", "123456789", "Ford", "Focus", kunde1);
	static Kunden kunden = new Kunden();

	public static void erstellen() throws JAXBException {
		Kunden kunden = new Kunden();
		kunden.setKunde(Arrays.asList(kunde1, kunde2, kunde3));
		JAXBContext context = JAXBContext.newInstance(Kunden.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(kunden, System.out);
	}

}
