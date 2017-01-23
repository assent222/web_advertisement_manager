package pkk.interview.entity;

import pkk.interview.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 21.01.2017.
 */

@Entity
@Table(name = "APP")
public class App extends BaseEntity {

    @Column(name = "APP_NAME", nullable = false)
    private String name;

    @Column(name = "APP_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private AppType type;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "CONTETN_TYPE")
    @JoinTable(name = "APP_CONTETN_TYPE")
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ContetnType.class)
    private List<ContetnType> contetnTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppType getType() {
        return type;
    }

    public void setType(AppType type) {
        this.type = type;
    }

    public List<ContetnType> getContetnTypes() {
        return contetnTypes;
    }

    public void setContetnTypes(List<ContetnType> contetnTypes) {
        this.contetnTypes = contetnTypes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", contetnTypes=" + contetnTypes +
                ", user=" + user +
                '}';
    }
}
