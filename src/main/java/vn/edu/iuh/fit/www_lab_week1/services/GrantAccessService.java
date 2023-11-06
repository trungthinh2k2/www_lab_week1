package vn.edu.iuh.fit.www_lab_week1.services;

import vn.edu.iuh.fit.www_lab_week1.models.GrantAccess;
import vn.edu.iuh.fit.www_lab_week1.repositories.GrantAccessRepository;

import java.util.List;

public class GrantAccessService {
    private GrantAccessRepository grantAccessRepository = new GrantAccessRepository();

    public List<GrantAccess> getGrantAccessByAccountId(String accountId) {
        return grantAccessRepository.getGrantAccessByAccountId(accountId);
    }
    public boolean insertGrantAccess(GrantAccess grantAccess) {
        return grantAccessRepository.insertGrantAccess(grantAccess);
    }
}
