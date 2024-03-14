import com.aks.pojo.User;
import com.aks.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 14:31
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
@SpringJUnitConfig(locations = "classpath:applicationContext.xml")
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void getTest(){
        User user = userService.findUser("net001", "r203");
        System.out.println(user.toString());
    }
}
