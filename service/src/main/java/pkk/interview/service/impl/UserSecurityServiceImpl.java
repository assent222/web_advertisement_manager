package pkk.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pkk.interview.entity.User;
import pkk.interview.entity.UserSecurity;
import pkk.interview.repository.UserRepository;
import pkk.interview.repository.UserSecurityRepository;
import pkk.interview.service.UserSecurityService;
import pkk.interview.service.UserService;
import pkk.interview.service.base.impl.BaseServiceImpl;

/**
 * Created by root on 23.01.2017.
 */
@Service
public class UserSecurityServiceImpl extends BaseServiceImpl<UserSecurity> implements UserSecurityService {

    @Autowired
    public UserSecurityServiceImpl(UserSecurityRepository repository) {
        super(repository);
    }
}
