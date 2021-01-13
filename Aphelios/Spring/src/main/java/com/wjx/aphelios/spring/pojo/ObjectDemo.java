package com.wjx.aphelios.spring.pojo;

import java.util.*;

/**
 * @author WJX
 * @since 2018/4/21 17:25
 */
public class ObjectDemo {
    private Object[] arrays;
    private List<Object> list;
    private Set<Object> set;
    private Map<String, Object> map;
    private Properties properties;

    public Object[] getArrays() {
        return arrays;
    }

    public void setArrays(Object[] arrays) {
        this.arrays = arrays;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Set<Object> getSet() {
        return set;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public ObjectDemo() {
    }

    public ObjectDemo(Object[] arrays, List<Object> list, Set<Object> set, Map<String, Object> map, Properties properties) {
        this.arrays = arrays;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "ObjectDemo{" +
                "arrays=" + Arrays.toString(arrays) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
