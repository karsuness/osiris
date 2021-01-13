package com.wjx.aphelios.mybatis.mybatis02.dao;


import com.wjx.mybatis01.domain.User;

import java.util.List;

/**
 * @author WJX
 * @since 2018/4/24 15:32
 */
public interface UserDao {
    /**
     * 通过id获取user信息
     *
     * @param id id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 通过名称获取user
     * @param name 名称
     * @return
     */
    List<User> getUserByName(String name);

    /**
     * 插入user
     * @param user 要插入的user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 修改用户
     * @param user user信息
     * @return
     */
    Integer updateUserById(User user);

    /**
     * 通过id删除user
     * @param id id
     * @return
     */
    Integer deleteById(Integer id);

    /**
     * 获取全部用户信息
     * @return
     */
    List<User> listUser();

}
