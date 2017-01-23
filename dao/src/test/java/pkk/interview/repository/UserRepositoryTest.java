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
import pkk.interview.entity.UserSecurity;

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
    @Autowired
    private UserSecurityRepository userSecurityRepository;

    @BeforeClass
    public static void setUpClass() throws IOException {
        log.info(">> setUpClass");
        File db = new File("./hsqldb");
        if (db.exists()) {
            FileUtils.deleteDirectory(db);
        }
        if (db.exists()) {
            throw new IllegalStateException();
        }
        log.info("<< setUpClass");
    }


    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws Exception {
        log.info(">> setUp");

        for (int i = 0; i < 10; i++) {
            UserSecurity entity = new UserSecurity();
            entity.setName("U" + i);
            entity.setEmail("U" + i + "@gmail.com");
            entity.setRole(UserRole.values()[i % 3]);
            entity.setLogin("LOG_" + i);
            entity.setPassword("PASS" + i);
            manager.merge(entity);
        }

        log.info("<< setUp");
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCount() {
        log.info(">> testCount");
        List<User> all = (List<User>) userRepository.findAll();
        log.info("## userList = {}"+ Arrays.toString(all.toArray()));
        Assert.assertEquals(10, all.size());
        log.info("<< testCount");
    }
    @Test
    @Transactional
    @Rollback(false)
    public void testUpdate() {
        log.info(">> testUpdate");
        User entity = userRepository.findOne(1);
        entity.setName("Egor");
        userRepository.save(entity);
        System.out.println(userSecurityRepository.findOne(1));
//        userSecurityRepository.findAll();
        log.info("<< testUpdate");
    }
}