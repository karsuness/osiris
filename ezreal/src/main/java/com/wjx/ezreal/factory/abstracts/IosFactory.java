package com.wjx.ezreal.factory.abstracts;

/**
 * @author wangjinxin
 * @date 2021/3/11 20:16
 * @mail wjxScott@icloud.com
 * @description
 */
public class IosFactory implements SystemFactory {
    @Override
    public OperationControl getOperationControl() {
        return new IosOperationControl();
    }

    @Override
    public UIControl getUIControl() {
        return new IosUIControl();
    }
}
