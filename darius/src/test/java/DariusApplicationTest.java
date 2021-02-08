import com.wjx.darius.DariusApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author liusha
 * @date 2021/2/7 16:27
 * @mail liusha@wacai.com
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DariusApplication.class)
@WebAppConfiguration
public abstract class DariusApplicationTest {
}