package com.wjx.aphelios.springmvc.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * user 实体类
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 地址
     */
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "com.wjx.mybatis01.domain.User [id=" + id + ", username=" + username + ", sex=" + sex
                + ", birthday=" + birthday + ", address=" + address + "]";
    }


}
