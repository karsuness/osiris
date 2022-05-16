package com.wjx.osiris.hecarim.utils;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public class OrikaBeanUtils {

    private static final MapperFactory MAPPER_FACTORY = new DefaultMapperFactory.Builder().build();

    /**
     * 对象拷贝
     */
    public static <S, D> D copyBean(S sourceBean, Class<D> targetClass) {
        if (sourceBean == null) {
            return null;
        }
        MAPPER_FACTORY.classMap(sourceBean.getClass(), targetClass);
        MapperFacade mapper = MAPPER_FACTORY.getMapperFacade();
        return mapper.map(sourceBean, targetClass);
    }

    /**
     * list转换
     */
    public static <S, D> List<D> copyArray(List<S> sourceClass, Class<D> targetClass) {
        if (sourceClass == null) {
            return new ArrayList<>();
        }

        return MAPPER_FACTORY.getMapperFacade().mapAsList(sourceClass, targetClass);
    }
}
