package com.wjx.brand.domain;

/**
 * @author WJX
 * @since 2018/5/6 15:00
 */

import java.io.Serializable;

/**
 * user实体类
 */
public class User implements Cloneable, Serializable {
    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User() {
        System.out.println("construct method");
    }

    public User(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("construct method");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        System.out.println("this is toString()");
        return "toString()";
    }
}
