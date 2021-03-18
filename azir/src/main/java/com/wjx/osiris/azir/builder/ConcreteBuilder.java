package com.wjx.osiris.azir.builder;

/**
 * @author wangjinxin
 * @date 2021/3/15 21:56
 * @mail wjxScott@icloud.com
 * @description 实际构造者
 */
public class ConcreteBuilder implements Builder {

    Computer computer = new Computer();

    @Override
    public void buildBrand(String brand) {
        this.computer.setBrand(brand);
    }

    @Override
    public void buildCpu(String cpu) {
        this.computer.setCpu(cpu);
    }

    @Override
    public void buildMainBoard(String mainBoard) {
        this.computer.setMainBoard(mainBoard);
    }

    @Override
    public void buildHardDisc(String hardDisc) {
        this.computer.setHardDisc(hardDisc);
    }

    @Override
    public void buildMemory(String memory) {
        this.computer.setMemory(memory);
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}
