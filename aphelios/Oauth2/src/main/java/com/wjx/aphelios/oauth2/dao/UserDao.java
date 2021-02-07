package com.wjx.aphelios.oauth2.dao;


import com.wjx.aphelios.oauth2.domain.User;

/**
 * @author WJX
 * @since 2018/5/23 19:29
 */
public interface UserDao {
    /**
     * 通过account查找用户信息
     *
     * @param account 账号
     * @return user信息
     */
    User getUserByAccount(String account);

    /**
     * 用户注册
     *
     * @param user user信息
     * @return 数据库影响行数
     */
    int register(User user);
}
