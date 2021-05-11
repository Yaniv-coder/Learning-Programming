package com.yan.study.designpattern.singleton;

/**
 * 单例模式场景.
 *
 * @author: YanJiaqi
 * @date: 2021/4/3 0003 11:04
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    /**
     * 主方法.
     * @param args 启动参数
     */
    public static void main(String[] args) {
        final Singleton instance = Singleton.getInstance();
        instance.plus();
        System.out.println(instance.getCount());
        final Singleton instance1 = Singleton.getInstance();
        instance1.plus();
        System.out.println(instance1.getCount());
    }
}
