package com.yan.study.designpattern.factorymethod.domain;

/**
 * 白人.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:28
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class WhiteHuman implements IHuman {
    /**
     * 肤色.
     */
    @Override
    public void getColor() {
        System.out.println("白色皮肤..");
    }

    /**
     * 行走.
     */
    @Override
    public void walk() {
        System.out.println("白人在行走...");
    }

    /**
     * 说话.
     */
    @Override
    public void talk() {
        System.out.println("白人说着单字节的话....");
    }
}
