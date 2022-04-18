package com.wjx.osiris.galio;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjx.osiris.galio.entity.User;
import com.wjx.osiris.galio.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class GalioApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = User.builder()
                .age(31)
                .userName("jlz")
                .password("888888")
                .name("jlz")
                .email("123@qq.com")
                .address("china")
                .build();

        userMapper.insert(user);


        List<User> users = userMapper.selectList(null);
        log.info("user list is {}", users);
        System.out.println(users);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 1);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "jl");

        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);

        System.out.println(userIPage);


    }

}
