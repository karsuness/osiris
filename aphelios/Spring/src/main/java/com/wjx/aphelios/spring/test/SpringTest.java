package com.wjx.aphelios.spring.test;

/**
 * @author WJX
 * @since 2018/4/21 21:18
 */

import com.wjx.aphelios.spring.pojo.User;
import com.wjx.aphelios.spring.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 测试spring整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    private User user;

    @Resource(name = "service")
    private Service service;

    @Test
    public void test1() {
        System.out.println(user);
    }

    @Test
    public void test2() {
        service.add();
    }

}
