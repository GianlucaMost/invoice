package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gianlucamost on 30.05.16.
 */
public class AutoDAOImpl implements AutoDAO {
    public String[] findById(int id) throws SQLException {
        String sqlstmt = "SELECT kennzeichen, marke, typ FROM auto WHERE fahrgestellnr = ?";

        Connection conn = MySQLConnection.getInstance();
        String ausgabe[] = new String[4];
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
                pstmt.setInt(1, id);

                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        ausgabe[0] = resultSet.getString("kennzeichen");
                        ausgabe[1] = resultSet.getString("marke");
                        ausgabe[2] = resultSet.getString("typ");
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
