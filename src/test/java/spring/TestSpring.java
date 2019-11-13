package spring;

import com.biefeng.spring.SpringConfiguration;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author BieFeNg
 * @Date 2018-06-09 14:35
 * @Desc
 */

public class TestSpring {

    ApplicationContext context;
    @Before
    public void setUp() throws Exception {
        context =new AnnotationConfigApplicationContext(SpringConfiguration.class);
    }
}
