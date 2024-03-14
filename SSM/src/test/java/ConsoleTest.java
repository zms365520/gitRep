import com.aks.pojo.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 21:56
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class ConsoleTest {
    public static void main(String[] args) {
        System.out.println("哈哈");

        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a=(A)app.getBean("a");

        a.setName("zs");
        System.out.println(a.getName());


        //mysql -uroot -p
        //root
        //show databases;
        //use myshujuku;
        //show tables;
        //select * from ...
        //注册码：NAVH-WK6A-DMVK-DKW3

        //BeanDefinition
        //BeanDefinitionReader

        //BeanFactory

        //BeanFactoryPostProcessor  实现类： PlaceholderConfigurerSupport


    }
}
