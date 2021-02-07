package com.wjx.aphelios.mybatis.mybatis01.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author WJX
 * @since 2018/4/23 22:08
 */
public class MybatisDemo {
    @Test
    public void test() throws IOException {
        //加载核心配置文件
        String source = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        //根据id查询
        //User user = sqlSession.selectOne("userNamespace.getUserById", 10);
        //System.out.println(user);

        //根据用户名称模糊查询用户列表
//        List<User> list = sqlSession.selectList("userNamespace.getUserByName", "五");
//        list.stream().forEach(e -> System.out.println(e));

        //添加用户
        /*User user = new User();
        user.setUsername("周加意");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("淮南");
        int insertNum = sqlSession.insert("userNamespace.insertUser", user);
        sqlSession.commit();
        System.out.println(insertNum);*/

        //执行更新语句
        /*User user = new User();
        user.setId(27);
        user.setUsername("何炅292929");
        user.setBirthday(new Date());
        user.setAddress("222222sadfsafsafs");
        user.setSex("女");
        int i = sqlSession.update("userNamespace.updateUserById", user);
        sqlSession.commit();*/

        //删除
        int deleteNum = sqlSession.delete("userNamespace.deleteById", 27);
        System.out.println(deleteNum);
    }
}
