package vn.edu.iuh.fit.www_lab_week1.repositories;

import vn.edu.iuh.fit.www_lab_week1.connectdb.Connect;
import vn.edu.iuh.fit.www_lab_week1.models.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RoleRepository {

    public Optional<Role> findById(String roleId) {
        String sql = "select * from role where role_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getString(1));
                role.setRoleName(rs.getString(2));
                role.setDescription(rs.getString(3));
                role.setStatus(rs.getInt(4));
                return Optional.of(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
