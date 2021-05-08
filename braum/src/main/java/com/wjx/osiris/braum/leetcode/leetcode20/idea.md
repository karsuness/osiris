```java
public class Solution {
    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty()||map.get(c) != stack.peek()) {
                    return false;
                }else{
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
```

根据题目首先如果长度为奇数那么肯定返回false，后面我们可以遍历字符串，利用栈来保存数据，左括号全部需要入栈，当出现右括号时需要有匹配的数据，如果此时栈中无数据或者栈顶的无法匹配那么肯定返回失败