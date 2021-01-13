package com.wjx.aphelios.mybatis.mybatis02.test;

import com.wjx.mybatis01.domain.User;
import com.wjx.mybatis02.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author WJX
 * @since 2018/4/24 15:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringMybatisTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void getUserById() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getUserByName() {
        List<User> list = userDao.getUserByName("张");
        list.stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setBirthday(LocalDateTime.now());
        user.setUsername("魏元元");
        user.setAddress("马鞍山市");
        user.setSex("男");
        System.out.println(user);
        userDao.insertUser(user);
    }

    @Test
    public void update() {
        User user = userDao.getUserById(7);
        user.setBirthday(LocalDateTime.now());
        Integer updateNum = userDao.updateUserById(user);
        System.out.println(updateNum);
    }

    @Test
    public void deleteById() {
        Integer deleteNum = userDao.deleteById(31);
        System.out.println(deleteNum);
    }

    @Test
    public void testListUser() {
        List<User> users = userDao.listUser();
        users.stream().forEach(e ->{
            System.out.println(e);
            System.out.println(e.getBirthday().toLocalDate().toString());
        });
    }
}
