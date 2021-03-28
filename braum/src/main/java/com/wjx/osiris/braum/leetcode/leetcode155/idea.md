```java
public class MinStack {

    Stack<Integer> stack;
    List<Integer> list;
    int min;
    /**
     * initialize your data structure here.
     */
    public MinStack() {
        this.stack = new Stack<Integer>();
        this.list = new ArrayList<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(val);
            list.add(val);
        } else {
            stack.push(val);
            list.add(val);
            min = Math.min(val, min);
        }
    }

    public void pop() {
        int num = stack.pop();
        list.remove((Integer)num);
        if (num == min) {
            min = getMinFromList();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    private int getMinFromList() {
        if (list.size() == 0) {
            return 0;
        }

        int minNum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            minNum = Math.min(minNum,list.get(i));
        }
        return minNum;
    }
}

```

对于这题对于栈的基本操作内部定义一个Java的栈来完成需求，主要关心的是最小值的问题，我定义一个数字来存放这个最小值，每次取最小值时将这个值直接返回。另外定义一个列表来存放栈的元素，以便于如果此时的最小值被移除之后重新计算一个最小值


其他优解：
```java
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<>();
        min_stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || x <= min_stack.peek())
            min_stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min_stack.peek();
    }
}
```

- 借用一个辅助栈`min_stack`，用于存获取`stack`中最小值。

- **算法流程：**
    - **`push()`方法：** 每当`push()`新值进来时，如果 **小于等于** `min_stack`栈顶值，则一起`push()`到`min_stack`，即更新了栈顶最小值；
    - **`pop()`方法：** 判断将`pop()`出去的元素值是否是`min_stack`栈顶元素值（即最小值），如果是则将`min_stack`栈顶元素一起`pop()`，这样可以保证`min_stack`栈顶元素始终是`stack`中的最小值。
    - **`getMin()`方法：** 返回`min_stack`栈顶即可。

- **`min_stack`作用分析：**
    - `min_stack`等价于遍历`stack`所有元素，把升序的数字都删除掉，留下一个从栈底到栈顶降序的栈。
    - 相当于给`stack`中的降序元素做了标记，每当`pop()`这些降序元素，`min_stack`会将相应的栈顶元素`pop()`出去，保证其栈顶元素始终是`stack`中的最小元素。
