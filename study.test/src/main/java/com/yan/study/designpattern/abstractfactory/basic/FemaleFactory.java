package com.yan.study.designpattern.abstractfactory.basic;

import com.yan.study.designpattern.abstractfactory.domain.BlackFemaleHuman;
import com.yan.study.designpattern.abstractfactory.domain.IHuman;
import com.yan.study.designpattern.abstractfactory.domain.WhiteFemaleHuman;
import com.yan.study.designpattern.abstractfactory.domain.YellowFemaleHuman;

/**
 * 女性工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 23:11
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class FemaleFactory implements IHumanFactory {
    /**
     * 生产黑人.
     *
     * @return 黑人
     */
    @Override
    public IHuman createBlackHuman() {
        final BlackFemaleHuman blackFemaleHuman = new BlackFemaleHuman();
        System.out.println("复杂的创建过程...");

        return blackFemaleHuman;
    }

    /**
     * 生产白人.
     *
     * @return 白人
     */
    @Override
    public IHuman createWhiteHuman() {
        final WhiteFemaleHuman whiteFemaleHuman = new WhiteFemaleHuman();
        System.out.println("复杂的创建过程...");

        return whiteFemaleHuman;
    }

    /**
     * 生产黄人.
     *
     * @return 黄人
     */
    @Override
    public IHuman createYellowHuman() {
        final YellowFemaleHuman yellowFemaleHuman = new YellowFemaleHuman();
        System.out.println("复杂的创建过程...");

        return yellowFemaleHuman;
    }
}
