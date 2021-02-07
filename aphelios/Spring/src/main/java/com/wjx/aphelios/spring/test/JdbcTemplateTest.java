package com.wjx.aphelios.spring.test;


import com.wjx.aphelios.spring.pojo.User;
import com.wjx.aphelios.spring.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WJX
 * @since 2018/4/22 21:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {
    @Resource(name = "userService")
    private UserService userService;

    @Test
    public void test() {
        User user = new User();
        user.setName("陈增辉");
        user.setAge(22);
//        userService.add(user);
//        userService.update(user,5);
//        userService.deleteById(5);
//        userService.deleteAll();
        User userById = userService.getUserById(2);
        System.out.println(userById);

        List<User> userList = userService.getUserList();
        System.out.println(userList);

        Integer userCount = userService.getUserCount();
        System.out.println(userCount);
    }
}
