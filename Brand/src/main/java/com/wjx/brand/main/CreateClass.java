package com.wjx.brand.main;

/**
 * @author WJX
 * @since 2018/5/6 15:05
 */

import com.wjx.java.domain.User;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试5中创建对象的方法
 */
public class CreateClass {

    /**
     * 测试new关键字创建对象
     */
    @Test
    public void testNew() {
        User user = new User();
        System.out.println(user);
    }

    /**
     * 测试使用Class类创建对象
     */
    @Test
    public void testClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        User user = (User) Class.forName("com.wjx.java.domain.User").newInstance();
        System.out.println(user);
    }

    /**
     * 使用Constructor创建对象
     */
    @Test
    public void testContructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<User> constructor = User.class.getConstructor();
        User user = constructor.newInstance();
        System.out.println(user);
    }

    /**
     * 测试clone方法创建对象
     */
    @Test
    public void testClone() throws CloneNotSupportedException {
        User user = new User();
        User clone = (User) user.clone();
        System.out.println(user);
    }
}
