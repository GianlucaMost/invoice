package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gianlucamost on 30.05.16.
 */
public class KundeDAOImpl implements KundeDAO {

    public String[] findById(int id) throws SQLException {
        String sqlstmt = "SELECT name, vorname, addresse FROM Kunde WHERE kundennr = ?";

        Connection conn = MySQLConnection.getInstance();
        String ausgabe[] = new String[3];
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
                pstmt.setInt(1, id);

                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        ausgabe[0] = resultSet.getString("name");
                        ausgabe[1] = resultSet.getString("vorname");
                        ausgabe[2] = resultSet.getString("addresse");
                        return ausgabe;
                    } else {
                        return null;
                    }
                }
            }
        }
        return ausgabe;
    }

    public String[] findAllCostumerNumbers() throws SQLException {
        String sqlstmt = "SELECT kundennr FROM Kunde";

        Connection conn = MySQLConnection.getInstance();
        List<String> output = new ArrayList<String>();
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        output.add(resultSet.getString("kundennr"));
                    }
                }
            }
        }
        return output.toArray(new String[0]);
    }
}
