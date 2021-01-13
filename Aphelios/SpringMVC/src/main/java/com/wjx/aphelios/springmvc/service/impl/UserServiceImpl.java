package com.wjx.aphelios.springmvc.service.impl;

import com.wjx.aphelios.springmvc.dao.UserDao;
import com.wjx.aphelios.springmvc.domain.User;
import com.wjx.aphelios.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WJX
 * @since 2018/4/25 16:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }
}
