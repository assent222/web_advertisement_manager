package pkk.interview.entity;

import pkk.interview.entity.base.BaseEntity;

import javax.persistence.*;

/**
 * Created by root on 21.01.2017.
 */

@Entity
@Table(name = "USER")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User extends BaseEntity {

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    @Column(name = "USER_MAIL", nullable = false, unique = true)
    private String email;

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


    @Override
    public String toString() {
        return "User{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}