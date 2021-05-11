package com.yan.study.designpattern.singleton;

/**
 * 单例模式.
 *
 * @author: YanJiaqi
 * @date: 2021/4/2 0002 23:36
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public final class Singleton {
    /**
     * 实例对象.
     */
    private static final Singleton INSTANCE = new Singleton();

    /**
     * 计数器.
     */
    private int count = 0;

    /**
     * 禁止创建该对象实例.
     */
    private Singleton() {
        System.out.println( "此处省略复杂的初始化对象过程...");
    }

    /**
     * 获取单例对象.
     * @return 单例对象
     */
    public static Singleton getInstance() {
        return INSTANCE;
    }

    /**
     * 计数器加1.
     */
    public void plus() {
        ++count;
    }

    /**
     * 获取计数器值.
     * @return 计数器的值
     */
    public int getCount() {
        return count;
    }
}
