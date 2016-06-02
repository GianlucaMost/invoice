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
public class ErsatzteilDAOImpl implements ErsatzteilDAO {
    public String[] findById(int id) throws SQLException {
        String sqlstmt = "SELECT bezeichnung, preis, anzahl FROM ersatzteil WHERE nummer = ?";
        Connection conn = MySQLConnection.getInstance();
        String ausgabe[] = new String[3];
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
                pstmt.setInt(1, id);

                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        ausgabe[0] = resultSet.getString("bezeichnung");
                        ausgabe[1] = resultSet.getString("preis");
                        ausgabe[2] = resultSet.getString("anzahl");
                        return ausgabe;
                    } else {
                        return null;
                    }
                }
            }
        }
        return ausgabe;
    }

    public String[] findAllCostumer() throws SQLException {
        String sqlstmt = "SELECT bezeichnung FROM ersatzteil";

        Connection conn = MySQLConnection.getInstance();
        List<String> output = new ArrayList<String>();
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        output.add(resultSet.getString("bezeichnung"));
                    }
                }
            }
        }
        return output.toArray(new String[0]);
    }

    public float findPriceFrom(String bezeichnung) throws SQLException {
        String sqlstmt = "SELECT preis FROM ersatzteil WHERE bezeichnung = ?";
        Connection conn = MySQLConnection.getInstance();
        String ausgabe[] = new String[1];
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
                pstmt.setString(1, bezeichnung);

                try (ResultSet resultSet = pstmt.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getFloat("preis");
//                        ausgabe[0] = resultSet.getString("preis");
//                        return ausgabe;
                    } else {
//                        return null;
                    }
                }
            }
        }
        return 0.0f;
    }
}
