package com.wjx.brand.main;

/**
 * @author WJX
 * @since 2018/5/6 15:42
 */

import java.util.Arrays;
import java.util.List;

/**
 * list和array转换
 */
public class ListArray {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d", "e", "f"};
        List<String> list = Arrays.asList(strings);
        String[] array = new String[list.size()];
        String[] stringsArray = list.toArray(array);
        list.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println("*********************************");
        for (String string : stringsArray) {
            System.out.print(string + " ");
        }
    }
}
