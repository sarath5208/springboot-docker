package gov.cancer.ccr.oit.labmatrix.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataDemoApplicationTests
{
    private final Logger logger= LoggerFactory.getLogger(getClass());


    @Test
    public void contextLoads()
    {
        logger.info("Inside contextLoads");
        assertNotNull("Inside contextLoads");
    }
}
