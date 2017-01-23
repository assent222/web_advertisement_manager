package pkk.interview.service.base.impl;

import org.springframework.transaction.annotation.Transactional;
import pkk.interview.service.exception.ServiceException;
import pkk.interview.service.base.BaseService;
import pkk.interview.entity.base.BaseEntity;
import pkk.interview.repository.base.BaseRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by root on 23.01.2017.
 */

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    private BaseRepository<T> repository;

    public BaseServiceImpl(BaseRepository<T> repository) {
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
    public List<T> find() {
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
