package com.wjx.osiris.fizz.config.database;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

/**
 * @author wangjinxin
 * @date 2022/8/6 14:59
 * @mail wangjinxin03@corp.netease.com
 * @description
 */
public class DataSourceFactory {
    public static DataSource buildDefaultDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        return dataSource;
    }
}
