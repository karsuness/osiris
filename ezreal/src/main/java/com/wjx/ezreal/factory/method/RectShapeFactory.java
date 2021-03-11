package com.wjx.ezreal.factory.method;

import com.wjx.ezreal.factory.bean.RectShape;
import com.wjx.ezreal.factory.bean.Shape;

/**
 * @author liusha
 * @date 2021/3/11 19:33
 * @mail liusha@wacai.com
 * @description 正方形工厂
 */
public class RectShapeFactory implements SharpFactory {
    @Override
    public Shape getShape() {
        return new RectShape();
    }
}
