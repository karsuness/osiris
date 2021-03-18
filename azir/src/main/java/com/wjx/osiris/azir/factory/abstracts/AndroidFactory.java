package com.wjx.osiris.azir.factory.abstracts;

/**
 * @author wangjinxin
 * @date 2021/3/11 20:15
 * @mail wjxScott@icloud.com
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
