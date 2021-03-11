package com.wjx.ezreal.factory.method;

import com.wjx.ezreal.factory.bean.Shape;

/**
 * @author liusha
 * @date 2021/3/11 19:36
 * @mail liusha@wacai.com
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
