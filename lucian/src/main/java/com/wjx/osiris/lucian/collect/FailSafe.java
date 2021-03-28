package com.wjx.osiris.lucian.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangjinxin
 * @date 2021/3/29 01:31
 * @mail wjxScott@iCloud.com
 * @description
 */
public class FailSafe {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            map.put("666", "666");
            iterator.next();
        }
        System.out.println(map);
    }
}
