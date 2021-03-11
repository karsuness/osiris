package com.wjx.ezreal.factory.abstracts;

/**
 * @author liusha
 * @date 2021/3/11 20:15
 * @mail liusha@wacai.com
 * @description
 */
public class AndroidFactory implements SystemFactory {
    @Override
    public OperationControl getOperationControl() {
        return new AndroidOperationControl();
    }

    @Override
    public UIControl getUIControl() {
        return new AndroidUIControl();
    }
}
