package com.wjx.osiris.galio.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author liusha
 * @date 2022/4/27 16:58
 * @mail liusha@wacai.com
 * @description
 */
@Component
public class MyMetaObjectHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //先判断获取到值，如果为空则进行填充，否则不操作
        Object password = getFieldValByName("password", metaObject);

        if (Objects.isNull(password)) {
            setFieldValByName("password", "888888", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
