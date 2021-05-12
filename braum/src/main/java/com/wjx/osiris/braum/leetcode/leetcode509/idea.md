```java
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int num1 = fib(n - 2);
        map.put(n - 2, num1);

        int num2 = fib(n - 1);
        map.put(n - 1, num2);
        return num1 + num2;
    }
}
```

利用map存储已经计算之后的值避免重复计算