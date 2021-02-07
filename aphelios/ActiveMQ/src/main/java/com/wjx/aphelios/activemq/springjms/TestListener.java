package com.wjx.aphelios.activemq.springjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @author WJX
 * @since 2018/4/29 22:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestListener {
    @Test
    public void test() throws IOException {
        System.in.read();
    }
}
