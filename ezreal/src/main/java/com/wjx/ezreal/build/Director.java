package com.wjx.ezreal.build;

/**
 * @author wangjinxin
 * @date 2021/3/15 22:00
 * @mail wjxScott@icloud.com
 * @description builder模式中的指挥者
 */
public class Director {

    public Computer getMacBook() {
        Builder concreteBuilder = new ConcreteBuilder();
        concreteBuilder.buildBrand("MacBook Pro");
        concreteBuilder.buildCpu("ARM M1");
        concreteBuilder.buildMainBoard("Apple");
        concreteBuilder.buildHardDisc("512 SSD");
        concreteBuilder.buildMemory("32G");
        return concreteBuilder.getComputer();
    }

    public Computer getHuaWeiBook() {
        Builder concreteBuilder = new ConcreteBuilder();
        concreteBuilder.buildBrand("MateBook Pro");
        concreteBuilder.buildCpu("Intel i7");
        concreteBuilder.buildMainBoard("weixing");
        concreteBuilder.buildHardDisc("512 SSD");
        concreteBuilder.buildMemory("32G");
        return concreteBuilder.getComputer();
    }
}
