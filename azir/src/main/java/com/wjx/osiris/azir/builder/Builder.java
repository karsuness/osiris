package com.wjx.osiris.azir.builder;

/**
 * @author wangjinxin
 * @date 2021/3/15 21:34
 * @mail wjxScott@icloud.com
 * @description 构造者
 */
public interface Builder {

    /**
     * 品牌
     *
     * @param brand
     */
    void buildBrand(String brand);

    /**
     * 装配cpu
     *
     * @param cpu
     */
    void buildCpu(String cpu);

    /**
     * 装配主板
     *
     * @param mainBoard
     */
    void buildMainBoard(String mainBoard);

    /**
     * 装配硬盘
     *
     * @param hardDisc
     */
    void buildHardDisc(String hardDisc);

    /**
     * 装配内存
     *
     * @param memory
     */
    void buildMemory(String memory);

    Computer getComputer();
}
