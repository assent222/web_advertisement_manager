package pkk.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pkk.interview.entity.User;
import pkk.interview.entity.UserSecurity;
import pkk.interview.repository.UserRepository;
import pkk.interview.repository.UserSecurityRepository;
import pkk.interview.service.UserSecurityService;
import pkk.interview.service.UserService;
import pkk.interview.service.base.impl.BaseServiceImpl;
import pkk.interview.service.exception.ServiceException;

/**
 * Created by root on 23.01.2017.
 */
@Service
public class UserSecurityServiceImpl extends BaseServiceImpl<UserSecurity> implements UserSecurityService {

    UserSecurityRepository repository;

    @Autowired
    public UserSecurityServiceImpl(UserSecurityRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public UserSecurity findUserSecurityByLogin(String login) {
        try {
            return repository.findUserSecurityByLogin(login);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
