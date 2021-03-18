package com.wjx.osiris.azir.factory.abstracts;

/**
 * @author wangjinxin
 * @date 2021/3/11 20:18
 * @mail wjxScott@icloud.com
 * @description
 */
public class Main {
    public static void main(String[] args) {
        IosFactory iosFactory = new IosFactory();
        UIControl iosUiControl = iosFactory.getUIControl();
        OperationControl iosOperationControl = iosFactory.getOperationControl();

        AndroidFactory androidFactory = new AndroidFactory();
        UIControl androidUIControl = androidFactory.getUIControl();
        OperationControl androidOperationControl = androidFactory.getOperationControl();

        iosOperationControl.control();
        iosUiControl.display();

        androidOperationControl.control();
        androidUIControl.display();

    }
}
