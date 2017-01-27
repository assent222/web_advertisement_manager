import org.junit.Test;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import java.util.ArrayList;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
/**
 * Created by root on 26.01.2017.
 */
public class TestHateous {

    @Test
    public void test1() {
        User user = new User("Ivan", "PASS123");
        Resource<?> resource = new Resource<>(user);

        System.out.println(user);
        System.out.println(resource);
    }


    @Test
    public void test2() throws Exception {
        List<Resource> list = new ArrayList<>();
        list.add(new Resource<User>(new User("A", "A")));
        list.add(new Resource<User>(new User("B", "B")));

        Link link = linkTo(TestHateous.class).slash("/users").withSelfRel();
        Resources<Resource> resources = new Resources<>(list, link);

        System.out.println(resources);
    }

    static class User {
        private final String name;
        private final String pass;

        public User(String name, String pass) {
            this.name = name;
            this.pass = pass;
        }

        public String getName() {
            return name;
        }

        public String getPass() {
            return pass;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", pass='" + pass + '\'' +
                    '}';
        }
    }
}
