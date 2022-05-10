package com.wjx.osiris.galio;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjx.osiris.galio.entity.User;
import com.wjx.osiris.galio.entity.UserActiveRecord;
import com.wjx.osiris.galio.enums.SexEnum;
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
                .sex(SexEnum.WOMAN)
                .build();

        userMapper.insert(user);


        List<User> users = userMapper.selectList(null);
        log.info("user list is {}", users);
        System.out.println(users);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 1);

        String userName = null;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like("user_name", userName);

        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);

        System.out.println(userIPage);


    }

    @Test
    public void testModelSelect() {
        UserActiveRecord selectUserActiveRecord = UserActiveRecord.builder().build();

        UserActiveRecord userActiveRecord = selectUserActiveRecord.selectById(1L);

        System.out.println(userActiveRecord);
    }

    @Test
    public void testModelSave() {
        UserActiveRecord selectUserActiveRecord = UserActiveRecord
                .builder()
                .userName("test")
//                .password("123")
                .name("name")
                .age(11)
                .address("china")
                .email("xxxx@gmail.com")
                .build();

        selectUserActiveRecord.insert();
    }

    @Test
    public void testUpdateAllTable() {
        userMapper.delete(Wrappers.<User>lambdaQuery().eq(User::getId, 9L));

//        User userActiveRecord = User.builder()
//                .age(22)
//                .build();
//
//        userMapper.update(userActiveRecord, null);
    }

}
