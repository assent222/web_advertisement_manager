package pkk.interview;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private final Logger log = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void test() throws Exception {
        Assert.assertNotNull(log);
        log.warn("Hello log");
        log.debug("Hello log");
        log.info("Hello log");
        log.error("Hello log");
    }
}
