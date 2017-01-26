package pkk.interview.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pkk.interview.entity.User;

import javax.persistence.NamedQuery;

/**
 * Created by root on 21.01.2017.
 */

@Repository
@RestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Integer> {


    @Override
//    @Query(value = "SELECT * FROM User U", nativeQuery = true)
    Iterable<User> findAll();


    @Override
//    @Query(value = "SELECT * FROM User WHERE ID = ?1", nativeQuery = true)
    User findOne(Integer integer);
}
