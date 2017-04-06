package prog.logic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class DAOCustomer extends DAO<Customer, String> {
    DAOCustomer() throws Exception {
        connect();
    }

    List<Customer> getAll() {
        return null;
    }

    List<String> getAllKeys() throws SQLException {
        return null;
    }

    Customer read(String login) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT login, password, role_id FROM customer " +
                            "WHERE login=?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return null;
    }

    Customer getEntityById(String id) {
        return null;
    }

    Boolean update(Customer entity) {
        return null;
    }

    Boolean create(Customer entity) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(
                    "INSERT INTO customer " +
                            "(login, password, role_id) " +
                            "VALUES (?, ?, ?)");
            stmt.setString(1, entity.getLogin());
            stmt.setString(2, entity.getPassHash());
            stmt.setInt(3, entity.getRoleId());
            return stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    Boolean delete(String id) {
        return null;
    }

    Boolean isLoginNotExist(String login) throws SQLException {
        Customer customer = read(login);
        return customer == null;
    }
}
