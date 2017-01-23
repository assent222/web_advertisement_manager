package pkk.interview.service.base.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pkk.interview.entity.base.BaseEntity;
import pkk.interview.service.base.BaseService;
import pkk.interview.service.exception.ServiceException;


import java.util.Collections;
import java.util.List;

/**
 * Created by root on 23.01.2017.
 */

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private CrudRepository<T, Integer> repository;

    public BaseServiceImpl(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public T find(Integer id) {
        try {
            return repository.findOne(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        Iterable<T> entities;
        try {
            entities = repository.findAll();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        if (entities == null || !entities.iterator().hasNext()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList((List<T>) entities);
    }

    @Override
    public T create(T entity) {
        if (repository.exists(entity.getId())) {
            throw new ServiceException("This entity have already created=" + entity);
        }
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public T update(T entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(T entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
