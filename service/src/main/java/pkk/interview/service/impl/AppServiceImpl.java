package pkk.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pkk.interview.repository.AppRepository;
import pkk.interview.service.AppService;
import pkk.interview.service.base.impl.NamedServiceImpl;
import pkk.interview.entity.App;
import pkk.interview.repository.base.NamedRepository;

/**
 * Created by root on 23.01.2017.
 */
@Service
public class AppServiceImpl extends NamedServiceImpl<App> implements AppService {

    @Autowired
    public AppServiceImpl(AppRepository repository) {
        super(repository);
    }
}
