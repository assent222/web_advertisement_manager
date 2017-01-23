package pkk.interview.entity;

import javax.persistence.*;

/**
 * Created by root on 23.01.2017.
 */

@Entity
@Table(name = "SEC_USER")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 1)
@DiscriminatorValue("SEC_USER")
public class UserSecurity extends User {

    @Column(name = "SEC_USER_LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "SEC_USER_PASSWORD", nullable = false)
    private String password;

    @Column(name = "SEC_USER_ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserSecurity{" +
                "id=" + super.getId() +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                "} " + super.toString();
    }
}
