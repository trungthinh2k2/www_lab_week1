package vn.edu.iuh.fit.www_lab_week1.services;

import vn.edu.iuh.fit.www_lab_week1.models.Account;
import vn.edu.iuh.fit.www_lab_week1.repositories.AccountRepository;

import java.util.List;

public class AccountService {
    private final AccountRepository repository = new AccountRepository();

    public boolean insertAccount(Account account) {
        return repository.insert(account);
    }
    public List<Account> getListAccount() {
        return repository.getAll();
    }
    public void update(Account account) {
        repository.update(account);
    }
    public void delete(String accountId) {
        repository.delete(accountId);
    }
    public Account findById(String id) {
        return repository.findById(id);
    }
    public boolean authentication(String username, String password) throws Exception {
        return repository.authentication(username, password);
    }
    public void updateStatus(Account account, int status) {
        repository.updateStatus(account,status);
    }

}
