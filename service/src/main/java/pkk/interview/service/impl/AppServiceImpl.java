package pkk.interview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pkk.interview.repository.AppRepository;
import pkk.interview.service.AppService;
import pkk.interview.service.base.impl.BaseServiceImpl;
import pkk.interview.entity.App;

/**
 * Created by root on 23.01.2017.
 */
@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {

    @Autowired
    public AppServiceImpl(AppRepository repository) {
        super(repository);
    }
}
