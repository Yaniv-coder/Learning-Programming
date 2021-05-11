package com.yan.study.designpattern.abstractfactory.basic;

import com.yan.study.designpattern.abstractfactory.domain.BlackMaleHuman;
import com.yan.study.designpattern.abstractfactory.domain.IHuman;
import com.yan.study.designpattern.abstractfactory.domain.WhiteMaleHuman;
import com.yan.study.designpattern.abstractfactory.domain.YellowMaleHuman;

/**
 * 男性工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 23:09
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class MaleFactory implements IHumanFactory {
    /**
     * 生产黑人.
     *
     * @return 黑人
     */
    @Override
    public IHuman createBlackHuman() {
        final BlackMaleHuman blackMaleHuman = new BlackMaleHuman();
        System.out.println("复杂的创建过程...");

        return blackMaleHuman;
    }

    /**
     * 生产白人.
     *
     * @return 白人
     */
    @Override
    public IHuman createWhiteHuman() {
        final WhiteMaleHuman whiteMaleHuman = new WhiteMaleHuman();
        System.out.println("复杂的创建过程...");

        return whiteMaleHuman;
    }

    /**
     * 生产黄人.
     *
     * @return 黄人
     */
    @Override
    public IHuman createYellowHuman() {
        final YellowMaleHuman yellowMaleHuman = new YellowMaleHuman();
        System.out.println("复杂的创建过程...");

        return yellowMaleHuman;
    }
}
