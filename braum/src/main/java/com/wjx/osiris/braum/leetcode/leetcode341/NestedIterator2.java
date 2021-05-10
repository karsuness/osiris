package com.wjx.osiris.braum.leetcode.leetcode341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wangjinxin
 * @date 2021/5/9 15:47
 * @mail wjxScott@iCloud.com
 * @description
 */
public class NestedIterator2 implements Iterator<Integer> {

    private LinkedList<NestedInteger> nestedIntegers;

    public NestedIterator2(List<NestedInteger> nestedList) {
        //不直接使用nestedList的引用，是因为不能确定它的底层实现，必须保证是LinkedList，否则下面的addFirst会很低效
        nestedIntegers = new LinkedList<>(nestedList);
    }


    @Override
    public boolean hasNext() {
        //循环拆分列表元素，直到列表的第一个元素是整数类型
        while (!nestedIntegers.isEmpty() && !nestedIntegers.get(0).isInteger()) {
            //当列表开头第一个元素是列表类型时，进入循环
            List<NestedInteger> nestedIntegerList = nestedIntegers.remove(0).getList();
            //将第一个列表顺序添加到开头
            for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
                nestedIntegers.addFirst(nestedIntegerList.get(i));
            }
        }
        return !nestedIntegers.isEmpty();
    }

    @Override
    public Integer next() {
        return nestedIntegers.remove(0).getInteger();
    }
}
