package com.wjx.ezreal.factory.method;

import com.wjx.ezreal.factory.bean.Shape;
import com.wjx.ezreal.factory.bean.TriangleShape;

/**
 * @author liusha
 * @date 2021/3/11 19:34
 * @mail liusha@wacai.com
 * @description
 */
public class TriangleShapeFactory implements SharpFactory {

    @Override
    public Shape getShape() {
        return new TriangleShape();
    }
}
