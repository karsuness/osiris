package com.wjx.aphelios.springmvc.service;


import com.wjx.aphelios.springmvc.domain.User;

import java.util.List;

/**
 * @author WJX
 * @since 2018/4/25 16:02
 */
public interface UserService {
    List<User> queryUser();

    Integer insertUser(User user);
}
