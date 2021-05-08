```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            length = Math.max(length, j - i + 1);
        }
        return length;
    }
}
```

使用快慢指针的方式通过指针之间的长度作为子串的长度，利用map的key来存放字符，每次有相同的key时慢指针直接跳跃到这个字符的位置