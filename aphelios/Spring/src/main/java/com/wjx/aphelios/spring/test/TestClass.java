package com.wjx.aphelios.spring.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wjx.aphelios.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @author WJX
 * @since 2018/4/21 12:59
 */
public class TestClass {


    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User) context.getBean("user");
        // user.setName("testName");
//        user.setAge(20);
        System.out.println(user);
       /* ObjectDemo objectDemo = (ObjectDemo) context.getBean("object");
        System.out.println(objectDemo);*/
    }

    @Test
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///database");
        dataSource.setUser("root");
        dataSource.setPassword("wjx1415926");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int updateNum = jdbcTemplate.update("insert into user(name,age) values('jack',22)");
    }

}
