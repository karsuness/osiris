package com.wjx.osiris.braum.leetcode.leetcode009;

/**
 * @author wangjinxin
 * @date 2021/3/25 22:59
 * @mail wjxScott@iCloud.com
 * @description
 */
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
