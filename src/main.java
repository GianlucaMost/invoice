import logic.Auto;
import logic.Kunde;
import ui.GUI;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gianlucamost on 03.05.16.
 */
public class main {
    public static void main(String [] args) throws JAXBException {

/*
        Kunde kunde = new Kunde("Mustermann", "Max", 123, "Musterstr.");
        Auto car = new Auto("", "", "", "", kunde);
        kunde.addAuto(car);
*/
        Datenhaltung.erstellen();

        try {
            GUI window = new GUI();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
