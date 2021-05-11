package com.yan.study.designpattern.factorymethod.simple;

import com.yan.study.designpattern.factorymethod.basic.HumanFactory;
import com.yan.study.designpattern.factorymethod.basic.IHumanFactory;
import com.yan.study.designpattern.factorymethod.domain.BlackHuman;
import com.yan.study.designpattern.factorymethod.domain.WhiteHuman;
import com.yan.study.designpattern.factorymethod.domain.YellowHuman;

/**
 * 简单工厂模式（静态工厂）场景.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:40
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final WhiteHuman whiteHuman = HumanSimpleFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.walk();
        whiteHuman.talk();

        final BlackHuman blackHuman = HumanSimpleFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.walk();
        blackHuman.talk();

        final YellowHuman yellowHuman = HumanSimpleFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.walk();
        yellowHuman.talk();
    }
}
