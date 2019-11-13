import com.biefeng.spring.SpringConfiguration;
import com.biefeng.spring.aop.Audience;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author BieFeNg
 * @Date 2018-06-06 21:16
 * @Desc
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SpringConfiguration.class})
public class TestSpring {
    ApplicationContext context;
    @Before
    public void setUp() throws Exception {
         //context= new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    }



    @Test
    public void name() {
        System.out.println(context.getBean("audience"));
    }
}
