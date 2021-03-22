```java
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            //n&1结果前31位全部为0，result为0或1
            int result = n & 1;
            if (result == 1) {
                count++;
            }
            //无符号右移一位
            n = n >>> 1;
        }
        return count;
    }
}
```

对32个位数每一个都进行判断，首先用结果&1，那么最终结果的前31肯定是0（0与其他&的结果都为0），这样&的结果肯定是0或1，我们判断这个结果即可，如果是1就结果+1，通过无符号右移，最左位用0填充，循环处理直到所有位数都为0，退出