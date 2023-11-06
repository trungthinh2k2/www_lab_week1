package vn.edu.iuh.fit.www_lab_week1.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import vn.edu.iuh.fit.www_lab_week1.connectdb.Connect;
import vn.edu.iuh.fit.www_lab_week1.models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AccountRepository {

    public boolean insert(Account account){
        String sql = "insert into account(account_id, full_name, password, email, phone, status)values(?,?,?,?,?,?)";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getAccountId());
            ps.setString(2, account.getFullName());
            ps.setString(3, account.getPassword());
            ps.setString(4, account.getEmail());
            ps.setString(5, account.getPhone());
            ps.setInt(6, account.getStatus());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        String sql = "update account set full_name = ?, password = ?, email = ?, phone = ? where account_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getFullName());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getPhone());
            ps.setString(5, account.getAccountId());
            int rs = ps.executeUpdate();
            if(rs < 0)
                insert(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean authentication(String username, String password) {
        Account account = findById(username);
        if(account != null) {
            if(password.equals(account.getPassword()))
                return true;
        }
        return false;
    }

    public Account findById(String id) {
        String sql = "select * from account where account_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getString(1));
                account.setFullName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setStatus(rs.getInt(6));
                return account;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Account> getAll() {
        String sql = "select * from account";
        List<Account> accounts = new ArrayList<>();
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccountId(rs.getString(1));
                account.setFullName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setStatus(rs.getInt(6));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;

    }
    public void delete(String accountId) {
        String sql = "delete from account where account_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accountId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStatus(Account account, int status) {
        account.setStatus(status);
    }
}