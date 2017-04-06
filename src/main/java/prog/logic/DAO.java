package prog.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

abstract class DAO<E, K> {
    Connection connection = null;
    void connect () throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/FileManagerInfo";
            connection = DriverManager.getConnection(url, "root", "123");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    abstract List<E> getAll() throws SQLException;

    abstract List<K> getAllKeys() throws SQLException;

    abstract E read(K id) throws SQLException;

    abstract E getEntityById(K id);

    abstract Boolean update(E entity) throws SQLException;

    abstract Boolean create(E entity) throws SQLException;

    abstract Boolean delete(K id);
}
