package com.wjx.brand.main;

/**
 * @author WJX
 * @since 2018/5/6 15:55
 */

/**
 * 可变参数方法
 */
public class VariableClass {
    public static void main(String[] args) {
        printMethod("a", "5", "q", "12");
    }

    public static void printMethod(String... strings) {
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
