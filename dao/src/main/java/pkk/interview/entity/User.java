package pkk.interview.entity;

import pkk.interview.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by root on 21.01.2017.
 */

@Entity
@Table(name = "USER")
@Inheritance(strategy=InheritanceType.JOINED)
public class User extends BaseEntity {

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_MAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "USER_ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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