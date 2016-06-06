package persistence;

import java.sql.SQLException;

/**
 * Created by gianlucamost on 30.05.16.
 */
public interface AutoDAO {
    public String[] findById(int id) throws SQLException;
}
