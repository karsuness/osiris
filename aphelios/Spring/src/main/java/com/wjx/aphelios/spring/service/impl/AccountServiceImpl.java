package com.wjx.aphelios.spring.service.impl;

import com.wjx.aphelios.spring.dao.AccountDao;
import com.wjx.aphelios.spring.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author WJX
 * @since 2018/4/22 22:30
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;
    @Resource(name = "transactionTemplate")
    private TransactionTemplate transactionTemplate;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    @Override
    public void transfer(Integer from, Integer to, Long money) {
        //减钱
        accountDao.decreaseMoney(from, money);
        int i = 1 / 0;
        //加钱
        accountDao.increaseMoney(to, money);
    }


    /*@Override
    public void transfer(Integer from, Integer to, Long money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                //减钱
                //java 8自动转换成final形式
                accountDao.decreaseMoney(from, money);
                int i = 1 / 0;
                //加钱
                accountDao.increaseMoney(to, money);
            }
        });
    }*/
}
