package com.yan.study.designpattern.factorymethod.multi;

import com.yan.study.designpattern.factorymethod.domain.IHuman;

/**
 * 多工厂方法模式场景.
 *
 * @author: YanJiaqi
 * @date: 2021/4/9 0009 0:00
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final IHumanMultiFactory blackFactory = new BlackHumanFactory();
        final IHuman blackHuman = blackFactory.createHuman();
        blackHuman.getColor();
        blackHuman.walk();
        blackHuman.talk();

        final IHumanMultiFactory whiteFactory = new WhiteHumanFactory();
        final IHuman whiteHuman = whiteFactory.createHuman();
        whiteHuman.getColor();
        whiteHuman.walk();
        whiteHuman.talk();
    }
}
