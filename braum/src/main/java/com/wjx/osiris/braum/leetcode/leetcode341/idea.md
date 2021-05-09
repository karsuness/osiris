```java
public class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
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
```

解法一：我们先定义一个integer的iterator，后面定义一个方法来解析这个NestedInteger，将他的integer全部放到list中，但是这个对象中可能会存在list，所以在这个方法的内部要进行判断接着递归进行处理，最后直接返回这个总结果list的iterator

```java
public class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> nestedIntegers;

    public NestedIterator(List<NestedInteger> nestedList) {
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
```

解法二：本解法的核心是不特意生成一个integer的list，而是特意找到每个元素为list的实例，并将这些元素全部转成integer并按照顺序放回原先的list