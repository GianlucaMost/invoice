package persistence;

import java.sql.SQLException;

/**
 * Created by gianlucamost on 30.05.16.
 */
public interface KundeDAO {
    public String[] findById(int id) throws SQLException;
    public String[] findAllCostumerNumbers() throws SQLException;
}
