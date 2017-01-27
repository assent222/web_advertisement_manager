package pkk.interview.service.base;

import pkk.interview.entity.base.BaseEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by root on 23.01.2017.
 */

@Transactional
public interface BaseService<T extends BaseEntity> {

    @Transactional(Transactional.TxType.SUPPORTS)
    T find(Integer id);

    @Transactional(Transactional.TxType.SUPPORTS)
    List<T> findAll();

    T create(T entity);

    T update(T entity);

    void delete(T entity);
}