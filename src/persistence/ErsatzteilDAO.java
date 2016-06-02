package persistence;

import java.sql.SQLException;

/**
 * Created by gianlucamost on 30.05.16.
 */
public interface ErsatzteilDAO {
    public String[] findById(int id) throws SQLException;
    public String[] findAllCostumer() throws SQLException;
    public float findPriceFrom(String bezeichnung) throws SQLException;
}
