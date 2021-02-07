package com.wjx.brand.demo;

/**
 * @author WJX
 * @since 2018/5/21 20:03
 */

import java.util.Random;

/**
 * 简单抢红包算法
 * 算法原理：
 * 维护一个剩余总金额和总数量，分配时，如果数量等于1，直接返回总金额，如果大于1计算平均值，
 * 假设随机值最大值为平均值的2倍，然后取一个随机数，如果随机值小于0.01则为0.01，这个随机数就是下一个红包的金额
 */
public class RedPacket {
    /**
     * 剩余总金额
     */
    private int leftMoney;
    /**
     * 剩余红包数
     */
    private int leftNum;
    /**
     * 随机函数
     */
    private Random random;

    public RedPacket(int title, int num) {
        this.leftMoney = title;
        this.leftNum = num;
        this.random = new Random();
    }

    public synchronized int getRedPacket() {
        if (this.leftMoney <= 0) {
            throw new IllegalStateException("红包已经抢光了，下次早点来哦！！！");
        }
        //最后一个红包放入全部金额
        if (this.leftNum == 1) {
            return this.leftMoney;
        }
        double max = this.leftMoney / this.leftNum * 2D;
        int money = (int) (random.nextDouble() * max);
        money = Math.max(money, 1);
        this.leftMoney -= money;
        this.leftNum--;
        return money;
    }

    public static void main(String[] args) {
        int titleMoney = 1000;
        int num = 11;
        RedPacket redPacket = new RedPacket(titleMoney, num);
        int result = 0;
        for (int i = 0; i < num; i++) {
            int money = redPacket.getRedPacket();
            result += money;
            System.out.println(money);
        }
        System.out.println("------------------------");
        System.out.println(result);
    }
}
