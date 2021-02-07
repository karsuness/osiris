package com.wjx.brand.demo;

/**
 * @author WJX
 * @since 2018/5/12 10:30
 */

/**
 * 求1！+2！+...+n!
 */
public class FibonacciDemo {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    public static int fibonacci(int n) {
        if (n < 0) {
            throw new RuntimeException("负数没有阶乘");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) * n;
        }
    }

    public static long getfibonacci(int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result += fibonacci(i);
        }
        return result;
    }
}
