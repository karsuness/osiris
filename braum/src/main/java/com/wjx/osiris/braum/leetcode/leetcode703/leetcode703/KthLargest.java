package com.wjx.osiris.braum.leetcode.leetcode703.leetcode703;

/**
 * @author wangjinxin
 * @date 2021/4/1 23:43
 * @mail wjxScott@iCloud.com
 * @description
 */
public class KthLargest {
    private int[] heap;
    /**
     * 堆内数量
     */
    private int size = 0;

    public KthLargest(int k, int[] nums) {
        this.heap = new int[k];
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (size < heap.length) {
            heap[size] = val;
            up(heap, size++);
        } else if (val > heap[0]) {
            heap[0] = val;
            down(heap, heap.length, 0);
        }
        return heap[0];
    }

    /**
     * 下沉,弹出堆顶时，维护堆的性质，小根堆，父节点小于等于子节点
     */
    private void down(int[] array, int n, int i) { //维护小根堆
        //左孩子
        int lson = i * 2 + 1;

        //右孩子
        int rson = i * 2 + 2;
        int smallest = i;
        if (lson < n && array[lson] < array[smallest]) {
            smallest = lson;
        }
        if (rson < n && array[rson] < array[smallest]) {
            smallest = rson;
        }
        //保证父节点是最小的
        if (smallest != i) {
            swap(array, i, smallest);
            down(array, n, smallest);
        }
    }

    /**
     * 上浮，堆尾插入数据，维护堆的性质，小根堆，父节点小于等于子节点
     */
    private void up(int[] array, int i) {
        int parent = (i - 1) / 2;
        if (parent >= 0 && array[i] < array[parent]) {
            swap(array, parent, i);
            up(array, parent);
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
