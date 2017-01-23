package pkk.interview.repository.base;

import org.springframework.data.repository.CrudRepository;
import pkk.interview.entity.base.BaseEntity;

/**
 * Created by root on 23.01.2017.
 */
public interface BaseRepository<T extends BaseEntity> extends CrudRepository<T, Integer>{
}
