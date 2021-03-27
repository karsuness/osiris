```java
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] array = s.toCharArray();

        int preElement = map.get(array[0]);
        int sum = 0;

        for (int i = 1; i < array.length; i++) {
            int element = map.get(array[i]);

            if (element > preElement) {
                sum -= preElement;
            } else {
                sum += preElement;
            }
            preElement = element;
        }
        sum +=  preElement;
        return sum;
    }
}
```

根据题目可知当小数在大数左边时要减掉这个数，反之加上这个数，我们一次性看两个数，利用变量来保存前一位数字，通过将字符串转成数组来遍历字符串判断，最后一位可以直接加上

使用map来保存和获取映射关系会消耗比较多的内存，在这种映射已知并且较少的情况先可以使用switch的方式来获取映射

```java
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
```
