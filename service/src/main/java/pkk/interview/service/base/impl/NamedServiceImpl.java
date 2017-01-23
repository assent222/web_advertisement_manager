package pkk.interview.service.base.impl;

import org.springframework.transaction.annotation.Transactional;
import pkk.interview.service.exception.ServiceException;
import pkk.interview.service.base.NamedService;
import pkk.interview.entity.base.NamedEntity;
import pkk.interview.repository.base.NamedRepository;

import java.util.Collections;
import java.util.List;

/**
 * Created by root on 23.01.2017.
 */
public abstract class NamedServiceImpl<T extends NamedEntity> extends BaseServiceImpl<T> implements NamedService<T>  {

    private NamedRepository<T> repository;

    public NamedServiceImpl(NamedRepository<T> repository) {
        super(repository);
    }

    @Transactional(readOnly = true)
    public List<T> findByName(String name) {
        Iterable<T> entities;
        try {
            entities = repository.findByName(name);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        if (entities == null || !entities.iterator().hasNext()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList((List<T>) entities);
    }
}
