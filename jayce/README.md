# jayce

&emsp;&emsp;jayce 杰斯

- Springboot+MyBatis Plus+Sharding jdbc实现分库分表操作

建表语句

```sql
create databases ds0;
create databases ds1;

# 两个数据库中表中分别执行

CREATE TABLE `user_info_0`
(
    `id`        bigint(32) unsigned                                      NOT NULL auto_increment COMMENT '主键',
    `name`      varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
    `sex`       varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
    `age`       int(11)                        DEFAULT NULL COMMENT '年龄',
    create_time timestamp                      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp                      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '结束时间',
    `status`    tinyint(1)                     DEFAULT NULL default 1 COMMENT '是否删除 1删除 0未删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `user_info_1`
(
    `id`        bigint(32) unsigned                                      NOT NULL auto_increment COMMENT '主键',
    `name`      varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
    `sex`       varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
    `age`       int(11)                        DEFAULT NULL COMMENT '年龄',
    create_time timestamp                      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp                      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '结束时间',
    `status`    tinyint(1)                     DEFAULT NULL default 1 COMMENT '是否删除 1删除 0未删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `user_info_3`
(
    `id`        bigint(32) unsigned                                      NOT NULL auto_increment COMMENT '主键',
    `name`      varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
    `sex`       varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
    `age`       int(11)                        DEFAULT NULL COMMENT '年龄',
    create_time timestamp                      default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time timestamp                      default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '结束时间',
    `status`    tinyint(1)                     DEFAULT NULL default 1 COMMENT '是否删除 1删除 0未删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
```