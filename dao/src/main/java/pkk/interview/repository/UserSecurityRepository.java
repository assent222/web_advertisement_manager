package pkk.interview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pkk.interview.entity.UserSecurity;

/**
 * Created by root on 23.01.2017.
 */

@Repository
public interface UserSecurityRepository extends CrudRepository<UserSecurity, Integer>{

    UserSecurity findUserSecurityByLogin(String login);
}
