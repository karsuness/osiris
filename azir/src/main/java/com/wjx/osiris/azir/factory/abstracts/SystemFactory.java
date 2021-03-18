package com.wjx.osiris.azir.factory.abstracts;

/**
 * @author wangjinxin
 * @date 2021/3/11 20:10
 * @mail wjxScott@icloud.com
 * @description
 */
public interface SystemFactory {
    OperationControl getOperationControl();

    UIControl getUIControl();
}
