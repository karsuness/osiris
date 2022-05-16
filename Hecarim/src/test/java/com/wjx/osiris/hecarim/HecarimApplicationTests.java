package com.wjx.osiris.hecarim;

import com.wjx.osiris.hecarim.domain.User;
import com.wjx.osiris.hecarim.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
class HecarimApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

        User user = userService.getUserById(1L);

        log.info("user is {}", user);
    }

    @Test
    public void test() {
        int i = LocalDateTime.now().compareTo(LocalDateTime.now().minusDays(5));
        System.out.println(i);
    }
}