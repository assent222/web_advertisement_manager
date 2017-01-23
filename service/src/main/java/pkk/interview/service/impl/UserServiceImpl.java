package pkk.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pkk.interview.repository.UserRepository;
import pkk.interview.service.UserService;
import pkk.interview.service.base.impl.NamedServiceImpl;
import pkk.interview.entity.User;
import pkk.interview.repository.base.NamedRepository;

/**
 * Created by root on 23.01.2017.
 */
@Service
public class UserServiceImpl extends NamedServiceImpl<User> implements UserService {

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
