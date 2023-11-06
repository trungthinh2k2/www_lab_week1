package vn.edu.iuh.fit.www_lab_week1.models;


public class GrantAccess {

    private Account account;

    private Role role;

    private boolean isGrant;

    private String note;

    public GrantAccess() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account=" + account.getAccountId() +
                ", role=" + role.getRoleId() +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}