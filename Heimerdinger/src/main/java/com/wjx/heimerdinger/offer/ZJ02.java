package com.wjx.heimerdinger.offer;

/**
 * @author wangjinxin
 * @date 2020/12/16 21:24
 * @mail wjxScott@163.com
 * @description 剑指offer02 替换空格
 */
public class ZJ02 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(ch);
            }
        }
        return stringBuffer.toString();
    }

    public String replaceSpace1(StringBuffer str) {
        if (str == null) {
            return null;
        } else {
            return str.toString().replace(" ", "%20");
        }
    }
}
