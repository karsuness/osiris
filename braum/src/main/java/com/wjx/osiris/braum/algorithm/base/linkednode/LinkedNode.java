package com.wjx.osiris.braum.algorithm.base.linkednode;

import lombok.Data;

/**
 * @author wangjinxin
 * @date 2021/4/4 21:47
 * @mail wjxScott@iCloud.com
 * @description 链表节点
 */
@Data
public class LinkedNode {

    Integer value;

    LinkedNode next;

    public LinkedNode(int num) {
        this.value = num;
    }
}
