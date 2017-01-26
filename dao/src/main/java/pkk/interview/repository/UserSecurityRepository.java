package pkk.interview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pkk.interview.entity.UserSecurity;

/**
 * Created by root on 23.01.2017.
 */

@Repository
@RepositoryRestResource(exported = false)
public interface UserSecurityRepository extends CrudRepository<UserSecurity, Integer>{

    UserSecurity findUserSecurityByLogin(String login);
}
