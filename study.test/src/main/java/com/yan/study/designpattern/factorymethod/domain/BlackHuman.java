package com.yan.study.designpattern.factorymethod.domain;

/**
 * 黑人.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:28
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BlackHuman implements IHuman {
    /**
     * 肤色.
     */
    @Override
    public void getColor() {
        System.out.println("黑色皮肤..");
    }

    /**
     * 行走.
     */
    @Override
    public void walk() {
        System.out.println("黑人在走路...");
    }

    /**
     * 说话.
     */
    @Override
    public void talk() {
        System.out.println("黑人说着我们听不懂的话....");
    }
}
