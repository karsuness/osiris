package com.wjx.aphelios.spring.dao.impl;

import com.wjx.aphelios.spring.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author WJX
 * @since 2018/4/22 22:25
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public void increaseMoney(Integer id, Long money) {
        jdbcTemplate.update("update account set money = money+? where id = ? ", money, id);

    }

    @Override
    public void decreaseMoney(Integer id, Long money) {
        jdbcTemplate.update("update account set money = money-? where id = ? ", money, id);
    }
}
