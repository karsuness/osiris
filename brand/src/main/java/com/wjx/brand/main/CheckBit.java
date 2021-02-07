package com.wjx.brand.main;

/**
 * @author WJX
 * @since 2018/5/6 19:33
 */

/**
 * 判断一个数是多少位
 */
public class CheckBit {
    public static void main(String[] args) {
        System.out.println(check(110));
    }

    public static int check(int num) {
        if (num < 0) {
            return -1;
        }
        int[] bits = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        for (int i = 0; ; i++) {
            if (num <= bits[i]) {
                return i + 1;
            }
        }
    }
}
