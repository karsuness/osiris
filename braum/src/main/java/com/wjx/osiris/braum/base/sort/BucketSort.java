package com.wjx.osiris.braum.base.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author wangjinxin
 * @date 2020/12/10 21:33
 * @mail wjxScott@iCloud.com
 * @description 桶排序
 */
public class BucketSort {
    public static int[] bucketSort(int[] array) {
        int max = array[0];
        int min = array[0];
        for (int num : array) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int bucketNum = (max - min) / 2 + 1;

        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>(bucketNum);

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }

        //将每个元素放进桶中
        for (int num : array) {
            int position = (num - min) / array.length;
            bucketList.get(position).add(num);
        }

        //每个桶进行排序
        int[] arrays = new int[array.length];
        int index = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            ArrayList<Integer> integers = bucketList.get(i);
            Collections.sort(integers);
            for (int j = 0; j < integers.size(); j++) {
                arrays[index++] = integers.get(j);
            }
        }
        return arrays;
    }
}
