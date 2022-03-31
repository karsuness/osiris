package com.wjx.osiris.fiora;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class FioraApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(FioraApplication.class, args);
        System.out.println(configurableApplicationContext);

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);

        ConfigurableListableBeanFactory beanFactory = configurableApplicationContext.getBeanFactory();

        Map<String, Object> map = (Map<String, Object>) singletonObjects.get(beanFactory);

        map.entrySet().stream().filter(e -> e.getKey().startsWith("component")).forEach(e -> {
            System.out.println(e.getKey() + ":" + e.getValue());
        });

    }

}
