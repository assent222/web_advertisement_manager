package pkk.interview.entity.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by root on 23.01.2017.
 */

@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
