package com.wjx.osiris.azir.factory.simple;

import com.wjx.osiris.azir.factory.bean.CircleShape;
import com.wjx.osiris.azir.factory.bean.RectShape;
import com.wjx.osiris.azir.factory.bean.Shape;
import com.wjx.osiris.azir.factory.bean.TriangleShape;

/**
 * @author wangjinxin
 * @date 2021/3/11 11:49
 * @mail wjxScott@icloud.com
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
