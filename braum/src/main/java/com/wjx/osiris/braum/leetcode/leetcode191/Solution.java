package com.wjx.osiris.braum.leetcode.leetcode191;

/**
 * @author wangjinxin
 * @date 2021/3/22 23:53
 * @mail wjxScott@iCloud.com
 * @description
 */
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
