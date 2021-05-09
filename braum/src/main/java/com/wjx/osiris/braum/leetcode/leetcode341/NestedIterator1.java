package com.wjx.osiris.braum.leetcode.leetcode341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liusha
 * @date 2021/5/9 15:19
 * @mail liusha@wacai.com
 * @description
 */
public class NestedIterator1 implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator1(List<NestedInteger> nestedList) {
        //存放结果
        LinkedList<Integer> list = new LinkedList<>();
        for (NestedInteger nestedInteger : nestedList) {
            //处理每个元素
            reverse(nestedInteger, list);
        }
        //获取到迭代器
        this.iterator = list.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public void reverse(NestedInteger nestedInteger, LinkedList<Integer> nestedIntegerList) {
        if (nestedInteger.isInteger()) {
            nestedIntegerList.add(nestedInteger.getInteger());
        }

        List<NestedInteger> list = nestedInteger.getList();
        for (NestedInteger subNestInteger : list) {
            reverse(subNestInteger, nestedIntegerList);
        }
    }
}
