package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
