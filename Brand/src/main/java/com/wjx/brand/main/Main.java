package com.wjx.brand.main;

import java.util.*;

/**
 * @author WJX
 * @since 2018/5/27 10:43
 */
public class Main {
    public static void main1(String[] args) {
        Map<String, String> map1 = new HashMap<>(1);
        Map<String, String> map2 = new HashMap<>();
        map1.put("demo1", "demo1");
        map1.put("demo2", "demo2");
        map1.put("demo3", "demo3");
        map2.put("demo4", "demo4");
        map2.put("demo5", "demo5");
        map2.put("demo6", "demo6");
        Set<Map.Entry<String, String>> entries = map1.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
        }
    }

    public static void main2(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("demo1", "demo1");
        String put = map.put("demo2", "demo2");
        map.put("demo3", "demo3");
        Collection<String> values = map.values();
        values.stream().forEach(e -> System.out.println(e));
    }

    public static void main3(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add(null);
        set.add(new Integer(5));
        set.stream().forEach(e -> System.out.println(e));
    }

    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        map.put("a", "a");
        map.put("c", "c");
        map.put("D", "D");
        map.put("B", "B");
        map.put("Q", "Q");
        map.put("Z", "Z");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
