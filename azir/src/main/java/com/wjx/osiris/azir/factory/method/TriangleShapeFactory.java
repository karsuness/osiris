package com.wjx.osiris.azir.factory.method;

import com.wjx.osiris.azir.factory.bean.Shape;
import com.wjx.osiris.azir.factory.bean.TriangleShape;

/**
 * @author wangjinxin
 * @date 2021/3/11 19:34
 * @mail wjxScott@icloud.com
 * @description
 */
public class TriangleShapeFactory implements SharpFactory {

    @Override
    public Shape getShape() {
        return new TriangleShape();
    }
}
