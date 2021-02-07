import com.wjx.darius.domain.entity.UserDO;
import com.wjx.darius.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author liusha
 * @date 2021/2/7 16:05
 * @mail liusha@wacai.com
 * @description 测试类
 */
public class MybatisPlusTest extends DariusApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectMp() {
        List<UserDO> userDOS = userMapper.selectList(null);
        userDOS.stream().forEach(e -> {
            System.out.println(e);
        });
    }

    @Test
    public void testInsertMp() {
        UserDO userDO = UserDO.builder()
                .name("时间")
                .age(22)
                .email("www@123.com")
                .gmtCreate(LocalDateTime.now())
                .gmtModified(LocalDateTime.now())
                .build();
        userMapper.insert(userDO);
    }


}
