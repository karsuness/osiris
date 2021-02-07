package com.wjx.heimerdinger.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wangjinxin
 * @date 2020/12/16 21:01
 * @mail wjxScott@163.com
 * @description
 */
public class Main {
    public static void main1(String[] args) {
        ZJ01 obj = new ZJ01();
        int[][] array = {{}};
        array[0] = new int[]{1, 2, 8, 9};
        array[1] = new int[]{2, 4, 9, 12};
        array[2] = new int[]{4, 7, 10, 13};
        array[3] = new int[]{6, 8, 11, 13};
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        Boolean find = obj.Find(16, array);
        System.out.println(find);
    }

    public static void main2(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        ZJ02 obj = new ZJ02();
        String s = obj.replaceSpace(str);
        System.out.println(s);
    }

    public static void main(String[] args) {
        ZJ03 zj03 = new ZJ03();
        ZJ03.ListNode node1 = new ZJ03().new ListNode(67);
        ZJ03.ListNode node2 = new ZJ03().new ListNode(0);
        node1.next = node2;
        ZJ03.ListNode node3 = new ZJ03().new ListNode(24);
        node2.next = node3;
        ZJ03.ListNode node4 = new ZJ03().new ListNode(58);
        node3.next = node4;
        ArrayList<Integer> arrayList = zj03.printListFromTailToHead(node1);
        System.out.println(arrayList);
    }
}
