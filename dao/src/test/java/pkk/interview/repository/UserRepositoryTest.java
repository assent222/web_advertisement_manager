package pkk.interview.repository;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkk.interview.entity.User;
import pkk.interview.entity.UserRole;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by root on 21.01.2017.
 */

@ContextConfiguration(locations = "classpath:spring-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {
    private final static Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

    @PersistenceContext(name = "myEmf")
    private EntityManager manager;

    @Autowired
    private UserRepository userRepository;

    @BeforeClass
    public static void setUpClass() throws IOException {
        log.debug(">> setUpClass");
        File db = new File("./hsqldb");
        if (db.exists()) {
            FileUtils.deleteDirectory(db);
        }
        if (db.exists()) {
            throw new IllegalStateException();
        }
        log.debug("<< setUpClass");
    }


    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws Exception {
        log.debug(">> setUp");

        for (int i = 0; i < 10; i++) {
            User entity = new User();
            entity.setName("U" + i);
            entity.setEmail("U" + i + "@gmail.com");
            entity.setRole(UserRole.values()[i % 3]);
//            entity.setPassword("qwer" + i);
            manager.merge(entity);
        }

        log.debug("<< setUp");
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCount() {
        log.debug(">> testCount");
        List<User> all = (List<User>) userRepository.findAll();
        log.debug("## userList = {}"+ Arrays.toString(all.toArray()));
        Assert.assertEquals(10, all.size());
        log.debug("<< testCount");
    }
}