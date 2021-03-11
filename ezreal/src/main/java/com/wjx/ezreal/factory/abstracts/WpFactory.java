package com.wjx.ezreal.factory.abstracts;

/**
 * @author liusha
 * @date 2021/3/11 20:17
 * @mail liusha@wacai.com
 * @description
 */
public class WpFactory implements SystemFactory {
    @Override
    public OperationControl getOperationControl() {
        return new WpOperationControl();
    }

    @Override
    public UIControl getUIControl() {
        return new WpUIControl();
    }
}
