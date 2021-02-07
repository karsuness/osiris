package com.wjx.aphelios.spring.service;

/**
 * @author WJX
 * @since 2018/4/22 22:29
 */
public interface AccountService {
    void transfer(Integer from, Integer to, Long money);
}
