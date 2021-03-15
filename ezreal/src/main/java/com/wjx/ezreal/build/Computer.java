package com.wjx.ezreal.build;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2021/3/15 21:30
 * @mail wjxScott@icloud.com
 * @description 构造者产品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {

    /**
     * 品牌
     */
    private String brand;

    /**
     * cpu
     */
    private String cpu;

    /**
     * 主板
     */
    private String mainBoard;

    /**
     * 硬盘
     */
    private String hardDisc;

    /**
     * 内存
     */
    private String memory;
}
