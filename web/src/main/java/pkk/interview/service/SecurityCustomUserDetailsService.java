package pkk.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pkk.interview.entity.UserSecurity;
import pkk.interview.service.UserSecurityService;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by root on 23.01.2017.
 */

public class SecurityCustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserSecurityService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserSecurity entity = service.findUserSecurityByLogin(login);
        if (entity == null) {
            throw new UsernameNotFoundException("Cant find user by login=" + login);
        }
        UserDetails userDetails = buildUserDetails(entity);

        return userDetails;
    }

    private UserDetails buildUserDetails(UserSecurity entity) {
        String password = entity.getPassword();
        String username = entity.getLogin();
        boolean isAccountNonExpired = true;
        boolean isAccountNonLocked = true;
        boolean isCredentialsNonExpired = true;
        boolean isEnabled = true;
        Collection<? extends GrantedAuthority> authorities
                = Collections.singleton(new SimpleGrantedAuthority(entity.getRole().toString()));

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return authorities;
            }

            @Override
            public String getPassword() {
                return password;
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public boolean isAccountNonExpired() {
                return isAccountNonExpired;
            }

            @Override
            public boolean isAccountNonLocked() {
                return isAccountNonLocked;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return isCredentialsNonExpired;
            }

            @Override
            public boolean isEnabled() {
                return isEnabled;
            }
        };
    }
}
