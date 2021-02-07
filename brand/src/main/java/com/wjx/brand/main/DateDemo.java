package com.wjx.brand.main;

/**
 * @author WJX
 * @since 2018/5/21 18:14
 */

import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间相关的类的demo
 */
public class DateDemo {
    public static void main(String[] args) {
        //输出时区
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID());
        //输出国家地区
        Locale locale = Locale.getDefault();
        System.out.println(locale.toString());
    }
}
