package com.wjx.osiris.jayce.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wjx.osiris.jayce.entity.UserInfo;
import com.wjx.osiris.jayce.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wangjinxin
 * @since 2022-09-25
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public void insert(UserInfo userInfo) {
        Random random = new Random(10);
        for (int i = 0; i < 30; i++) {
            UserInfo man = UserInfo.builder()
                    .name(userInfo.getName() + i)
                    .age(i + random.nextInt(10))
                    .sex(userInfo.getSex())
                    .build();
            userInfoMapper.insert(man);
        }
    }


    public UserInfo getUserInfo(UserInfo userInfo) {

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", userInfo.getName());

        return userInfoMapper.selectOne(queryWrapper);
    }
}
