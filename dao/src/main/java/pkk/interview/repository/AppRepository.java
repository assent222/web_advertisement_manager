package pkk.interview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import pkk.interview.entity.App;

/**
 * Created by root on 21.01.2017.
 */


@Repository
@RepositoryRestResource(exported = false)
public interface AppRepository extends CrudRepository<App, Integer> {

}
