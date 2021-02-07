package com.wjx.aphelios.springmvc.dao;


import com.wjx.aphelios.springmvc.domain.User;

import java.util.List;

/**
 * @author WJX
 * @since 2018/4/25 15:43
 */
public interface UserDao {
    List<User> queryUser();

    Integer insertUser(User user);
}
