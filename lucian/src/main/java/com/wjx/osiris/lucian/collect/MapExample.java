package com.wjx.osiris.lucian.collect;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author wangjinxin
 * @date 2021/3/29 01:24
 * @mail wjxScott@iCloud.com
 * @description
 */
public class MapExample {
    public static void main(String[] args) {
        Hashtable<String,String> table = new Hashtable<>();
        table.put("1","1");
        table.put("2","2");
        table.put("3","3");
        table.put("4","4");

        Iterator<String> iterator = table.keySet().iterator();
        while (iterator.hasNext()) {
            //抛出java.util.ConcurrentModificationException
            table.put("666","666");
            iterator.next();
        }

        Enumeration<String> enumeration = table.keys();
        while(enumeration.hasMoreElements()){
            table.put("666","666");
            enumeration.nextElement();
        }
        System.out.println(table);
    }
}
