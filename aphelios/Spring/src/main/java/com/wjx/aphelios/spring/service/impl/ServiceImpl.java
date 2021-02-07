package com.wjx.aphelios.spring.service.impl;

import com.wjx.aphelios.spring.service.Service;

/**
 * @author WJX
 * @since 2018/4/22 14:15
 */
public class ServiceImpl implements Service {
    @Override
    public void add() {
        System.out.println("add.......");
    }

    @Override
    public void query() {
        System.out.println("query......");
    }

    @Override
    public void delete() {
        System.out.println("delete......");
    }

    @Override
    public void save() {
        System.out.println("save.......");
    }
}
