package com.wjx.aphelios.oauth2.service;


import com.wjx.aphelios.oauth2.dao.UserDao;
import com.wjx.aphelios.oauth2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WJX
 * @since 2018/5/23 19:26
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User checkLogin(User loginUser) {
        String account = loginUser.getAccount();
        return userDao.getUserByAccount(account);
    }

    public boolean register(User user) {
        int insertNum = userDao.register(user);
        return insertNum > 0;
    }
}
