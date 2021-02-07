package com.wjx.aphelios.spring.test;

import com.wjx.aphelios.spring.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author WJX
 * @since 2018/4/22 22:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionTest {
    @Resource(name = "accountService")
    private AccountService accountService;

    @Test
    public void test() {
        accountService.transfer(1, 2, 500L);
    }
}
