package pkk.interview.controller.message;

/**
 * Created by root on 20.01.2017.
 */
public class UserJson {
    private String name;
    private Integer age;

    public UserJson() {
    }

    public UserJson(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserJson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
