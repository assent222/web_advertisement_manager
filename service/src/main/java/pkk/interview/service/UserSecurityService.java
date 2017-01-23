package pkk.interview.service;

import pkk.interview.entity.UserSecurity;
import pkk.interview.service.base.BaseService;

/**
 * Created by root on 23.01.2017.
 */
public interface UserSecurityService extends BaseService<UserSecurity> {

    UserSecurity findUserSecurityByLogin(String login);
}
