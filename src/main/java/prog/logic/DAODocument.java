package prog.logic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DAODocument extends DAO<Document, Integer> {
    DAODocument() throws Exception {
        connect();
    }

    List<Document> getAll() throws SQLException {
        List<Document> keys = new ArrayList<Document>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT document_id, name, owner, doc_path, " +
                            "parent_id, isDirectory, isProtected FROM document ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Boolean isDir = rs.getInt(6) != 0;
                Boolean isProt = rs.getInt(7) != 0;
                keys.add(new Document(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), isDir, isProt));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return keys;
    }

    List<Integer> getAllKeys() throws SQLException {
        List<Integer> keys = new ArrayList<Integer>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.prepareStatement(
                    "SELECT document_id FROM document ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                keys.add(rs.getInt(1));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return keys;
    }

    Document read(Integer id) throws SQLException {
        return null;
    }

    Document getEntityById(Integer id) {
        return null;
    }

    Boolean update(Document entity) {
        return null;
    }

    Boolean create(Document entity) {
        return null;
    }

    Boolean delete(Integer id) {
        return null;
    }
}
