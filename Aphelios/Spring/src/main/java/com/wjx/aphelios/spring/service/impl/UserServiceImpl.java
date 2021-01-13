package com.wjx.aphelios.spring.service.impl;


import com.wjx.aphelios.spring.dao.UserDao;
import com.wjx.aphelios.spring.pojo.User;
import com.wjx.aphelios.spring.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author WJX
 * @since 2018/4/22 21:03
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public Integer add(User user) {
        return userDao.add(user);
    }

    @Override
    public Integer update(User user, Integer id) {
        return userDao.update(user, id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public Integer deleteAll() {
        return userDao.deleteAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public Integer getUserCount() {
        return userDao.getUserCount();
    }
}
