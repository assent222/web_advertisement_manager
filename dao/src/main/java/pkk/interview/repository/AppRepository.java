package pkk.interview.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pkk.interview.entity.App;

/**
 * Created by root on 21.01.2017.
 */

@Repository
public interface AppRepository extends CrudRepository<App, Integer> {
}
