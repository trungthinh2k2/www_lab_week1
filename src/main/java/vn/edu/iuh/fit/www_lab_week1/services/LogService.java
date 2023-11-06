package vn.edu.iuh.fit.www_lab_week1.services;

import vn.edu.iuh.fit.www_lab_week1.models.Account;
import vn.edu.iuh.fit.www_lab_week1.models.Log;
import vn.edu.iuh.fit.www_lab_week1.repositories.AccountRepository;
import vn.edu.iuh.fit.www_lab_week1.repositories.LogRepository;

import java.sql.Timestamp;
import java.util.List;

public class LogService {
    private final LogRepository repository = new LogRepository();

    public boolean insertLog(Log log) {
        return repository.insertLog(log);
    }

    public void updateLogoutTime(long id, Timestamp logoutTime) {
        repository.updateLogoutTime(id, logoutTime);
    }

    public List<Log> getLogsByAccountId(String accountId) {
        return repository.getLogsByAccountId(accountId);
    }
}
