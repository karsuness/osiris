package com.wjx.aphelios.redis.test;

import com.wjx.redis.utils.RedisHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author WJX
 * @since 2018/4/27 12:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class RedisTest {
    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    @Resource(name = "redisHelper")
    private RedisHelper redisHelper;

    @Test
    public void addValue() {
        redisTemplate.boundValueOps("name").set("张皖川");
    }

    @Test
    public void getValue() {
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void setList() {
        redisTemplate.boundListOps("list").rightPush("张皖川");
        redisTemplate.boundListOps("list").rightPush("张皖川");
        redisTemplate.boundListOps("list").rightPush("张皖川");
        redisTemplate.boundListOps("list").rightPush("张皖川");
        redisTemplate.boundListOps("list").rightPush("张皖川");
        redisTemplate.boundListOps("list").rightPush("周加意");
        redisTemplate.boundListOps("list").rightPush("陈增辉");
        redisTemplate.boundListOps("list").rightPush("詹磊");
    }

    @Test
    public void getList() {
        List list = redisTemplate.boundListOps("list").range(0, 10);
        list.stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void setSet() {
        redisTemplate.boundSetOps("set").add("张皖川");
        redisTemplate.boundSetOps("set").add("周加意");
        redisTemplate.boundSetOps("set").add("张皖川");

    }

    @Test
    public void getSet() {
        Set set = redisTemplate.boundSetOps("set").members();
        System.out.println(set);

    }

    @Test
    public void setHash() {
        redisTemplate.boundHashOps("hash").put("name1", "张皖川");
        redisTemplate.boundHashOps("hash").put("name2", "周加意");
        redisTemplate.boundHashOps("hash").put("name3", "董彪");
        redisTemplate.boundHashOps("hash").put("name4", "陈增辉");
        redisTemplate.boundHashOps("hash").put("name5", "詹磊");
        redisTemplate.boundHashOps("hash").put("name6", "单成相");
    }

    @Test
    public void getHash() {
//        Object o = redisTemplate.boundHashOps("hash").keys();
//        Object o = redisTemplate.boundHashOps("hash").values();
        Object o = redisTemplate.boundHashOps("hash").get("name1");
        System.out.println(o);
    }


    @Test
    public void set() {
        List<String> list = Arrays.asList("张皖川", "周加意", "陈增辉", "詹磊");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("stringList", list);
    }

    @Test
    public void get() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        List<String> list = (List<String>) valueOperations.get("stringList");
        list.stream().forEach(e -> System.out.println(e));
    }

    @Test
    public void testSet() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        redisHelper.set("name", list, 500000000000L);
    }

    @Test
    public void testGet() {
        List<String> list = (List<String>) redisHelper.get("name");
        list.stream().forEach(e -> System.out.println(e));
    }
}
