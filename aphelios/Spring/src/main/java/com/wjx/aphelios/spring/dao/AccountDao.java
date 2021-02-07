package com.wjx.aphelios.spring.dao;

/**
 * @author WJX
 * @since 2018/4/22 22:25
 */
public interface AccountDao {
    //加钱
    void increaseMoney(Integer id, Long money);

    //减钱
    void decreaseMoney(Integer id, Long money);
}
