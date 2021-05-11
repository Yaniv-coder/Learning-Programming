package com.yan.study.designpattern.factorymethod.basic;

import com.yan.study.designpattern.factorymethod.domain.BlackHuman;
import com.yan.study.designpattern.factorymethod.domain.WhiteHuman;
import com.yan.study.designpattern.factorymethod.domain.YellowHuman;

/**
 * 普通工厂方法模式场景.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:40
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final IHumanFactory factory = new HumanFactory();
        final WhiteHuman whiteHuman = factory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.walk();
        whiteHuman.talk();

        final BlackHuman blackHuman = factory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.walk();
        blackHuman.talk();

        final YellowHuman yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.walk();
        yellowHuman.talk();
    }
}
