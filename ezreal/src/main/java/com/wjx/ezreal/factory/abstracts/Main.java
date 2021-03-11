package com.wjx.ezreal.factory.abstracts;

/**
 * @author liusha
 * @date 2021/3/11 20:18
 * @mail liusha@wacai.com
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
