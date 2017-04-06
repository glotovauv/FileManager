package prog.logic;

public class Permission {
    private String custLogin;
    private Integer docId;
    private Integer permissions;

    public Permission(String custLogin, Integer docId, Integer permissions) {
        this.custLogin = custLogin;
        this.docId = docId;
        this.permissions = permissions;
    }

    String getCustLogin() {
        return custLogin;
    }

    Integer getDocId() {
        return docId;
    }

    public Integer getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer permissions) {
        this.permissions = permissions;
    }
}
