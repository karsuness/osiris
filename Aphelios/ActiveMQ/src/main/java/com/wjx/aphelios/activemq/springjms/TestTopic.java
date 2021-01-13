package com.wjx.aphelios.activemq.springjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author WJX
 * @since 2018/4/29 21:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTopic {
    @Resource(name="topicProducer")
    private TopicProducer topicProducer;
    @Test
    public void test1(){
        topicProducer.send("jms send topic message");
    }
}
