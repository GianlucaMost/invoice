import persistence.*;
import ui.GUI;

import javax.xml.bind.JAXBException;

import logic.Steuerinformationen;

import java.sql.SQLException;

/**
 * Created by gianlucamost on 03.05.16.
 */
public class Start {
    public static void main(String [] args) throws JAXBException {
        KundeDAO knddoaimpl = new KundeDAOImpl();
        try {
            knddoaimpl.findAllCostumerNumbers();
          
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	logic.Steuerinformationen Infos = Steuerinformationen.getInfos();
        try {
            GUI window = new GUI();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {

    }
}
