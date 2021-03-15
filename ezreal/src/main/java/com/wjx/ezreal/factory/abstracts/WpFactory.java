package com.wjx.ezreal.factory.abstracts;

/**
 * @author wangjinxin
 * @date 2021/3/11 20:17
 * @mail wjxScott@icloud.com
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
