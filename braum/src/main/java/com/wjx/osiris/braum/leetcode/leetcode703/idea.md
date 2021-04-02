#### 初始化时
- 初始化堆【】
- 将初始化数组的数据，逐个入堆
#### 新增数据时
- 当堆数据不满K位，则直接加入到堆尾，然后从堆尾【上浮】，维护堆的性质
- 当数据满k位，且插入元素大于堆顶时，说明现在堆顶元素已经不再是前k大中的元素了，将其弹出，替换成新增数据，从根节点【下沉】维护堆的性质
- 当数据满k位，但插入元素小于等于堆顶时，说明其在后续数据流入也不会成为第k大的元素
#### 堆尾插入数据的上浮过程
![未命名文件 (22).png](https://pic.leetcode-cn.com/1613030228-eShuDv-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(22\).png) ![未命名文件 (23).png](https://pic.leetcode-cn.com/1613030247-HxcmMC-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(23\).png) ![未命名文件 (26).png](https://pic.leetcode-cn.com/1613030265-cgDImZ-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(26\).png) ![未命名文件 (25).png](https://pic.leetcode-cn.com/1613030280-voFSXb-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(25\).png) ![未命名文件 (27).png](https://pic.leetcode-cn.com/1613030835-CkwMzM-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(27\).png) ![未命名文件 (28).png](https://pic.leetcode-cn.com/1613030852-tNpQTK-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(28\).png) ![未命名文件 (29).png](https://pic.leetcode-cn.com/1613030859-kgduou-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(29\).png)

#### 堆顶弹出数据，换成新值后的下沉过程（同1）
![未命名文件 (13).png](https://pic.leetcode-cn.com/1613026146-InMhpT-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(13\).png) ![未命名文件 (14).png](https://pic.leetcode-cn.com/1613026157-uLYwzs-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(14\).png) ![未命名文件 (15).png](https://pic.leetcode-cn.com/1613026166-VVHbxP-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(15\).png) ![未命名文件 (16).png](https://pic.leetcode-cn.com/1613026173-OYbtIN-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(16\).png) ![未命名文件 (17).png](https://pic.leetcode-cn.com/1613026181-UizGGy-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(17\).png) ![未命名文件 (18).png](https://pic.leetcode-cn.com/1613026187-tKJXUC-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(18\).png) ![未命名文件 (19).png](https://pic.leetcode-cn.com/1613026195-GTtTbT-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(19\).png) ![未命名文件 (20).png](https://pic.leetcode-cn.com/1613026202-oWJNmv-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(20\).png) ![未命名文件 (21).png](https://pic.leetcode-cn.com/1613026210-mYgJwF-%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B6%20\(21\).png)
```java
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
```