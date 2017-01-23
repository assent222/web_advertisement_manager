package pkk.interview.entity;

import pkk.interview.entity.base.NamedEntity;

import javax.persistence.*;

/**
 * Created by root on 21.01.2017.
 */

@Entity
@Table(name = "USER")
public class User extends NamedEntity {

    @Column(name = "USER_MAIL", nullable = false)
    private String email;

    @Column(name = "USER_ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}