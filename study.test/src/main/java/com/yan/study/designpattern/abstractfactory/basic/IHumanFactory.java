package com.yan.study.designpattern.abstractfactory.basic;

import com.yan.study.designpattern.abstractfactory.domain.IHuman;

/**
 * 人类工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 23:06
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public interface IHumanFactory {

    /**
     * 生产黑人.
     * @return 黑人
     */
    IHuman createBlackHuman();

    /**
     * 生产白人.
     * @return 白人
     */
    IHuman createWhiteHuman();

    /**
     * 生产黄人.
     * @return 黄人
     */
    IHuman createYellowHuman();
}
