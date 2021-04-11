```java
public class Solution {
    public String reverseWords(String s) {
        if ("".equals(s) || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            } else if (i == chars.length - 1) {
                reverse(chars, start, i);
                start = i + 1;
            }
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int i) {
        while (start < i) {
            char temp = chars[start];
            chars[start] = chars[i];
            chars[i] = temp;
            start++;
            i--;
        }
    }
}

```

转成字符数组之后遍历遇到空格就将两个空格之间的字符串数组换位置