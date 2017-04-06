package prog.logic;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustService {
    private DAOCustomer daoCustomer;
    private DAODocument daoDocument;
    private DAOPermission daoPermission;

    public CustService(DAOCustomer daoCustomer, DAODocument daoDocument, DAOPermission daoPermission) {
        this.daoCustomer = daoCustomer;
        this.daoDocument = daoDocument;
        this.daoPermission = daoPermission;
    }

    CustService() throws Exception {
        this.daoCustomer = new DAOCustomer();
        this.daoDocument = new DAODocument();
        this.daoPermission = new DAOPermission();
    }

    Boolean register(String login, String hash) throws SQLException {
        if (!daoCustomer.isLoginNotExist(login)) return false;
        ArrayList<Document> files = (ArrayList<Document>) daoDocument.getAll();
        for (Document d : files) {
            if (d.getProtected()) daoPermission.create(new Permission(login, d.getDocId(), 1));
            else daoPermission.create(new Permission(login, d.getDocId(), 2));
        }
        daoCustomer.create(new Customer(login, hash, 1));
        return true;
    }
}
