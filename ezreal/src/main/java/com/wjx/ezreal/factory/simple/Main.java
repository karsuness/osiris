package com.wjx.ezreal.factory.simple;

import com.wjx.ezreal.factory.bean.CircleShape;
import com.wjx.ezreal.factory.bean.RectShape;
import com.wjx.ezreal.factory.bean.Shape;
import com.wjx.ezreal.factory.bean.TriangleShape;

/**
 * @author wangjinxin
 * @date 2021/3/11 11:52
 * @mail wjxScott@icloud.com
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Shape circleShape = ShapeSimpleactory.getShape(CircleShape.class.getName());
        Shape rectShape = ShapeSimpleactory.getShape(RectShape.class.getName());
        Shape triangleShape = ShapeSimpleactory.getShape(TriangleShape.class.getName());

        circleShape.draw();
        rectShape.draw();
        triangleShape.draw();
    }
}
