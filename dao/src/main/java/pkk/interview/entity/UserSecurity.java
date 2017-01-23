package pkk.interview.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by root on 23.01.2017.
 */

@Entity
@Table(name = "SECURITY_USER")
public class UserSecurity extends User {

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserSecurity{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
