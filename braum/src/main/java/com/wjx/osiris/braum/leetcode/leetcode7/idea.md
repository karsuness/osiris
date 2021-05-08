```java
public class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}
```

这种类型的反转显然是需要将每个数字拆开，这种整型的拆解我们肯定会想到使用/10以及%10的方式来获取每一位，这里我们不需要判断是否小于0，算出来的除数不会对结果有影响，但是需要注意的是题目中将一个数字反转之后可能会大于int的最大值2147483647，或者负数的情况小于-2147483648，那么我们计算结果的时候要注意当前一个算出来是2147484的时候那么最后一位如果大于7那么结果肯定会超过范围，同理负数时最后一位不能大于8