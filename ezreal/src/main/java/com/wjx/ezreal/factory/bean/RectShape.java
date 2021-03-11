package com.wjx.ezreal.factory.bean;

/**
 * @author liusha
 * @date 2021/3/11 11:45
 * @mail liusha@wacai.com
 * @description 正方形-子类
 */
public class RectShape implements Shape {

    public RectShape() {
        System.out.println("RectShape init");
    }

    @Override
    public void draw() {
        System.out.println("RectShape draw");
    }
}
