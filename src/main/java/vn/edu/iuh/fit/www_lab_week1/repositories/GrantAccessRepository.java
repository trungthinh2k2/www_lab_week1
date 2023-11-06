package vn.edu.iuh.fit.www_lab_week1.repositories;


import vn.edu.iuh.fit.www_lab_week1.connectdb.Connect;
import vn.edu.iuh.fit.www_lab_week1.models.Account;
import vn.edu.iuh.fit.www_lab_week1.models.GrantAccess;
import vn.edu.iuh.fit.www_lab_week1.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantAccessRepository {


    public List<GrantAccess> getGrantAccessByAccountId(String account_id) {
        String sql = "select * from grant_access where account_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        List<GrantAccess> grantAccesses = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GrantAccess grantAccess = new GrantAccess();
                grantAccess.setRole(new Role(rs.getString(1)));
                grantAccess.setAccount(new Account(rs.getString(2)));
                grantAccess.setGrant(rs.getBoolean(3));
                grantAccess.setNote(rs.getString(4));
                grantAccesses.add(grantAccess);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grantAccesses;
    }

    public boolean insertGrantAccess(GrantAccess grantAccess) {
        String sql = "insert into grant_access(role_id, account_id, is_grant) values (?, ?, ?)";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, grantAccess.getRole().getRoleId());
            ps.setString(2, grantAccess.getAccount().getAccountId());
            ps.setBoolean(3, grantAccess.isGrant());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  true;
    }

}
