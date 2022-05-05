package com.wjx.osiris.hecarim.service;

import com.wjx.osiris.hecarim.dao.UserMapper;
import com.wjx.osiris.hecarim.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liusha
 * @date 2022/5/3 15:11
 * @mail liusha@wacai.com
 * @description
 */
@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserById(Long id){
        return userMapper.selectById(id);
    }
}
