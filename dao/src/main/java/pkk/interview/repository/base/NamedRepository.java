package pkk.interview.repository.base;

import pkk.interview.entity.base.NamedEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 23.01.2017.
 */

public interface NamedRepository<T extends NamedEntity> extends BaseRepository<T> {

    List<T> findByName(String name);
}
