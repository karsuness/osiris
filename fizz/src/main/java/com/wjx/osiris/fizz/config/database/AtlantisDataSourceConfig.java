package com.wjx.osiris.fizz.config.database;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author wangjinxin
 * @date 2022/9/12 16:22
 * @mail wangjinxin03@corp.netease.com
 * @description 数据库配置
 */
@Configuration
@MapperScan(basePackages = "com.wjx.osiris.fizz.mapper", sqlSessionFactoryRef = "atlantisSqlSessionFactory")
public class AtlantisDataSourceConfig {

    @Bean(name = "atlantisDatasource")
    DataSource priDatasource() {
        return DataSourceFactory.buildDefaultDataSource();
    }

    @Primary
    @Bean(name = "atlantisSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Autowired(required = false) List<Interceptor> interceptors, @Qualifier("atlantisDatasource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        if (CollectionUtils.isNotEmpty(interceptors)) {
            factoryBean.setPlugins(interceptors.toArray(new Interceptor[interceptors.size()]));
        }
        return factoryBean.getObject();
    }

    @Bean(name = "atlantisTxManager")
    public PlatformTransactionManager txManager(@Qualifier("atlantisDatasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "atlantisTransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("atlantisTxManager") PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }
}
