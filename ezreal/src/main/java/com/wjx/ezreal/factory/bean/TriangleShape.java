package com.wjx.ezreal.factory.bean;

/**
 * @author wangjinxin
 * @date 2021/3/11 11:46
 * @mail wjxScott@icloud.com
 * @description 三角形-子类
 */
public class TriangleShape implements Shape {

    public TriangleShape() {
        System.out.println("TriangleShape init");
    }

    @Override
    public void draw() {
        System.out.println("TriangleShape draw");
    }
}
