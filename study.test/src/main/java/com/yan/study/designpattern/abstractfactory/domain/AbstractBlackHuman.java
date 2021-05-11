package com.yan.study.designpattern.abstractfactory.domain;

/**
 * 黑人.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:28
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public abstract class AbstractBlackHuman implements IHuman {
    /**
     * 肤色.
     */
    @Override
    public void getColor() {
        System.out.println("黑色皮肤..");
    }

    /**
     * 说话.
     */
    @Override
    public void talk() {
        System.out.println("黑人说着我们听不懂的话....");
    }
}
