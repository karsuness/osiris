```java
public class Solution {
    public  String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String first = strs[0];

        StringBuffer sb = new StringBuffer("");
        char[] array = first.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            for (int j = 1; j < strs.length; j++) {
                String match = strs[j];
                if (match.length() <= i || c != match.charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
```

由题可知当输入的数组为空或者只有一个的时候是特殊情况，首先特殊处理这种特殊情况，取出第一个字符串后对这个字符串进行遍历，传入的每个字符串的相同位置的字符进行匹配，出现长度不相同或者字符不匹配就直接返回，否则将字符暂时存入StringBuffer中