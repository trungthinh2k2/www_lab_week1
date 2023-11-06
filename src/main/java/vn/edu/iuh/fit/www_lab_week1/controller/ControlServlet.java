package vn.edu.iuh.fit.www_lab_week1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.www_lab_week1.models.Account;
import vn.edu.iuh.fit.www_lab_week1.models.GrantAccess;
import vn.edu.iuh.fit.www_lab_week1.models.Log;
import vn.edu.iuh.fit.www_lab_week1.models.Role;
import vn.edu.iuh.fit.www_lab_week1.services.AccountService;
import vn.edu.iuh.fit.www_lab_week1.services.GrantAccessService;
import vn.edu.iuh.fit.www_lab_week1.services.LogService;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ControlServlet")
public class ControlServlet extends HttpServlet {
    private final AccountService accountService;
    private final GrantAccessService grantAccessService;
    private final LogService logService;
    private long logId;

    public ControlServlet() {
        accountService = new AccountService();
        grantAccessService = new GrantAccessService();
        logService = new LogService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action){
            case  "delete-account":
                String idDelete = req.getParameter("accountIdDelete");
                System.out.println(idDelete);
                accountService.delete(idDelete);
                resp.sendRedirect("dashboard.jsp");
                break;
            case "logOut": {
                HttpSession session = req.getSession(false);
                if(session != null) {
                    session.invalidate();
                }

                logService.updateLogoutTime(logId, new Timestamp(System.currentTimeMillis()));
                resp.sendRedirect("index.jsp");
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("register")) {
            String accountId = req.getParameter("accountId");
            String fullName = req.getParameter("fullName");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            int status = 1;

            Account account = new Account(accountId, fullName, password, email, phone, status);
            accountService.insertAccount(account);
            resp.sendRedirect("index.jsp");
        }
        if (action.equals("login")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            try {
                if (accountService.authentication(username, password)) {
                    List<GrantAccess> grantAccesses = grantAccessService.getGrantAccessByAccountId(username);
                    List<Role> roles = new ArrayList<>();
                    for (GrantAccess grantAccess: grantAccesses) {
                        if(grantAccess.getRole().getRoleId().equals("admin")) {
                            resp.sendRedirect("dashboard.jsp");
                        }
                        else {
                            roles.add(grantAccess.getRole());
                            resp.sendRedirect("user.jsp?accountId="+username);
                        }
                    }

                    HttpSession session = req.getSession();
                    Object[] userRole = {username};

                    session.setAttribute("userName", userRole);
                    Log log = new Log();
                    long logId = System.currentTimeMillis();
                    log.setId(logId);
                    log.setLoginTime(new Timestamp(logId));
                    log.setAccountId(username);
                    logService.insertLog(log);
                }else {
                    resp.getWriter().println("Login fail");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(action.equals("insert-by-admin")) {
            String accountIdInsert = req.getParameter("accountId");
            String fullName = req.getParameter("fullName");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            int status = 1;

            Account account = new Account(accountIdInsert, fullName, password, email, phone, status);
            if(accountService.insertAccount(account)) {
                req.setAttribute("accounts", accountService.getListAccount());
                resp.sendRedirect("dashboard.jsp");
            }
        }
        if(action.equals("update")) {
            String accountId = req.getParameter("accountIdGrant");
            String fullName = req.getParameter("fullName");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            Account account = new Account(accountId, fullName, password, email, phone);
            accountService.update(account);
            resp.sendRedirect("dashboard.jsp");
        }

        if(action.equals("grant-access")) {
            GrantAccess grantAccess = new GrantAccess();
            String accountId = req.getParameter("accountIdGrant");
            String roleId = req.getParameter("grantAccess");
            grantAccess.setAccount(new Account(accountId));
            grantAccess.setRole(new Role(roleId));
            grantAccess.setGrant(true);
            grantAccessService.insertGrantAccess(grantAccess);
            resp.sendRedirect("dashboard.jsp");
        }
    }
}
