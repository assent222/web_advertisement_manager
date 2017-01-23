package pkk.interview.service.base;

import pkk.interview.entity.base.NamedEntity;

import java.util.List;

/**
 * Created by root on 23.01.2017.
 */
public interface NamedService<T extends NamedEntity> extends BaseService<T>{

    List<T> findByName(String name);
}
