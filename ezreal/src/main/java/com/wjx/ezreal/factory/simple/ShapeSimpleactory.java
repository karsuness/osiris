package com.wjx.ezreal.factory.simple;

import com.wjx.ezreal.factory.bean.CircleShape;
import com.wjx.ezreal.factory.bean.RectShape;
import com.wjx.ezreal.factory.bean.Shape;
import com.wjx.ezreal.factory.bean.TriangleShape;

/**
 * @author liusha
 * @date 2021/3/11 11:49
 * @mail liusha@wacai.com
 * @description 图形工厂
 */
public class ShapeSimpleactory {

    public static Shape getShape(String shapeName) {
        Shape shape = null;

        if (shapeName.equals(CircleShape.class.getName())) {
            shape = new CircleShape();
        } else if (shapeName.equals(RectShape.class.getName())) {
            shape = new RectShape();
        } else if (shapeName.equals(TriangleShape.class.getName())) {
            shape = new TriangleShape();
        }
        return shape;
    }
}
