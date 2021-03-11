package com.wjx.ezreal.factory.abstracts;

/**
 * @author liusha
 * @date 2021/3/11 20:10
 * @mail liusha@wacai.com
 * @description
 */
public interface SystemFactory {
    OperationControl getOperationControl();

    UIControl getUIControl();
}
