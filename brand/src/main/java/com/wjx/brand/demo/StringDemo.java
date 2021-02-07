package com.wjx.brand.demo;

import java.util.Comparator;

/**
 * @author WJX
 * @since 2018/5/21 14:17
 */
public class StringDemo {
    public static void main1(String[] args) {
        String str1 = "字符串demo";
        String str2 = "字符串demo";
        String str3 = new String("字符串demo");
        //使用常量直接赋值使用字符串常量池中数据
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }

    private static class CaseInsensitiveComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            int num1 = str1.length();
            int num2 = str2.length();

            int min = Math.min(num1, num2);

            for (int i = 0; i < min; i++) {
                char ch1 = str1.charAt(i);
                char ch2 = str2.charAt(i);

                if (ch1 != ch2) {
                    ch1 = Character.toUpperCase(ch1);
                    ch2 = Character.toUpperCase(ch2);

                    if (ch1 != ch2) {
                        ch1 = Character.toLowerCase(ch1);
                        ch2 = Character.toLowerCase(ch2);
                        if (ch1 != ch2) {
                            return ch1 - ch2;
                        }
                    }
                }
            }
            return num1 - num2;
        }

        public static void main(String[] args) {
            CaseInsensitiveComparator demo = new CaseInsensitiveComparator();
            String str1 = "Asdfg";
            String str2 = "ASdcf";
            demo.compare(str1, str2);
        }
    }
}
