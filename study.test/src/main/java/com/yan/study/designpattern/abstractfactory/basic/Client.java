package com.yan.study.designpattern.abstractfactory.basic;

import com.yan.study.designpattern.abstractfactory.domain.IHuman;

/**
 * 抽象工厂模式场景.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 23:13
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final IHumanFactory maleFactory = new MaleFactory();
        final IHuman blackMaleHuman = maleFactory.createBlackHuman();
        blackMaleHuman.getSex();

        final IHumanFactory femaleFactory = new FemaleFactory();
        final IHuman blackFemaleHuman = femaleFactory.createBlackHuman();
        blackFemaleHuman.getSex();
    }
}
