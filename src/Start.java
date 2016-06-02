import persistence.*;
import ui.GUI;

import javax.xml.bind.JAXBException;
import java.sql.SQLException;

/**
 * Created by gianlucamost on 03.05.16.
 */
public class Start {
    public static void main(String [] args) throws JAXBException {
        KundeDAO knddoaimpl = new KundeDAOImpl();
        try {
            knddoaimpl.findById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            GUI window = new GUI();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {

    }
}
