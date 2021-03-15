package com.wjx.darius.domain.util;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author wangjinxin
 * @date 2021/2/7 17:46
 * @mail wjxScott@icloud.com
 * @description mybatis plus自动生成工具
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //生成文件存放地址
        globalConfig.setOutputDir(System.getProperty("user.home") + "/Desktop/code")
                //生成文件是否覆盖
                .setFileOverride(true)
                //作者
                .setAuthor("wangjinxin")
                //是否打开文件夹
                .setOpen(true)
                //主键生成策略
                .setIdType(IdType.AUTO)
                //设置名称
                .setEntityName("%sDO")
                .setServiceName("%sService")
                .setMapperName("%sMapper");

        // 2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://wangjinxin.cn:3306/osiris?characterEncoding=utf-8&serverTimezone=GMT%2B8")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("wjx1415926");

        //3.策略配置
        StrategyConfig strategy = new StrategyConfig();
        //下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel)
                //大写
                .setCapitalMode(true)
                //下划线转驼峰命名
                .setColumnNaming(NamingStrategy.underline_to_camel)
                //是否生成实体时，生成字段注解
                .setEntityTableFieldAnnotationEnable(true)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                //扫描的表
                .setInclude("job_group","job_info","job_lock","job_log","job_log_report","job_logglue","job_registry","job_user");
        // 4.包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.wjx.osiris")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");


        //整合
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategy)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }
}
