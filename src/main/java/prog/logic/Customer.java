package prog.logic;

public class Customer {
    private String login;
    private String passHash;
    private Integer roleId;

    Customer(String login, String passHash, Integer roleId) {
        this.login = login;
        this.passHash = passHash;
        this.roleId = roleId;
    }

    public String getLogin() {
        return login;
    }

    Integer getRoleId() {
        return roleId;
    }

    String getPassHash() {
        return passHash;
    }
}
