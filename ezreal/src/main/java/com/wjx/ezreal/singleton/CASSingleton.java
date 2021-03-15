package com.wjx.ezreal.singleton;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangjinxin
 * @date 2021/3/10 20:16
 * @mail wjxScott@icloud.com
 * @description 利用CAS来实现线程安全
 */
public class CASSingleton {

    private static final AtomicReference<CASSingleton> INSTANCE = new AtomicReference<>();

    private CASSingleton() {
    }

    /**
     * CAS是为了保证线程安全
     *
     * @return
     */
    public static CASSingleton getInstance() {
        for (; ; ) {
            CASSingleton casSingleton = INSTANCE.get();
            if (Objects.nonNull(casSingleton)) {
                return casSingleton;
            }

            casSingleton = new CASSingleton();

            if (INSTANCE.compareAndSet(null, casSingleton)) {
                return casSingleton;
            }
        }
    }
}
