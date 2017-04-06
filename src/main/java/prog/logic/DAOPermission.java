package prog.logic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

class DAOPermission extends DAO<Permission, Pair<Integer, String>> {

    DAOPermission() throws Exception {
        connect();
    }

    List<Permission> getAll() throws SQLException {
        return null;
    }

    List<Pair<Integer, String>> getAllKeys() throws SQLException {
        return null;
    }

    Permission read(Pair<Integer, String> id) throws SQLException {
        return null;
    }

    Permission getEntityById(Pair<Integer, String> id) {
        return null;
    }

    Boolean update(Permission entity) throws SQLException {
        return null;
    }

    Boolean create(Permission entity) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO permission " +
                            "(cust_login, document_id, permissions) " +
                            "VALUES (?, ?, ?)");
            stmt.setString(1, entity.getCustLogin());
            stmt.setInt(2, entity.getDocId());
            stmt.setInt(3, entity.getPermissions());
            return stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    Boolean delete(Pair<Integer, String> id) {
        return null;
    }
}
