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
    public static String[] findByKunde(int kundennr) throws SQLException {
    	String sqlstmt = "SELECT fahrgestellnr from auto where fk_kundennr = ?";

        Connection conn = MySQLConnection.getInstance();
   
        List<String> output = new ArrayList<String>();
        if (conn != null) {
            try (PreparedStatement pstmt = conn.prepareStatement(sqlstmt)) {
            	pstmt.setInt(1, kundennr);
                try (ResultSet resultSet = pstmt.executeQuery()) {
                    while (resultSet.next()) {
                        output.add(resultSet.getString("fahrgestellnr"));
                    }
                }
            }
        }
        
		for (String i : output) {
        	  System.out.println(i);
        	}        
		 return output.toArray(new String[0]);
    }
    
}
