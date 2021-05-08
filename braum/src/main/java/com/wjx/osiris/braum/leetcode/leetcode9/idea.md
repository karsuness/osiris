```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x / 10 == 0) {
            return true;
        }


        int result = 0;
        int pototype = x;
        while (x != 0) {
            int temp = x % 10;
            if (result > 2147483647 || (result == 214748364 && temp > 7)) {
                return false;
            }
            result = result * 10 + temp;
            x /= 10;
        }
        return result == pototype;
    }
}
```

根据题目可知负数肯定返回false、10以下的肯定返回true，先排除这两种情况。利用反转数字的特性通过/10和%10，计算出这个反转的结果。要注意反转的过程中判断不能超过int的最大值，如果反转中出现大于int的情况，那么肯定不是回文数。反转结果之后判断结果即可