package com.wjx.osiris.azir.factory.method;


import com.wjx.osiris.azir.factory.bean.Shape;

/**
 * @author wangjinxin
 * @date 2021/3/11 19:36
 * @mail wjxScott@icloud.com
 * @description
 */
public class Main {
    public static void main(String[] args) {
        CircleShapeFactory circleShapeFactory = new CircleShapeFactory();
        RectShapeFactory rectShapeFactory = new RectShapeFactory();
        TriangleShapeFactory triangleShapeFactory = new TriangleShapeFactory();

        Shape circleShape = circleShapeFactory.getShape();
        Shape rectShape = rectShapeFactory.getShape();
        Shape factoryShape = triangleShapeFactory.getShape();

        rectShape.draw();
        circleShape.draw();
        factoryShape.draw();
    }
}
