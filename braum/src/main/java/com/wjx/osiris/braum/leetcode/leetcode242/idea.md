```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
```

异位词表示两个字符串的出现的字母相同但是顺序不同，这边对每个字符串转成字符数组之后进行排序，排序完比较两个数组是否完全一致即可