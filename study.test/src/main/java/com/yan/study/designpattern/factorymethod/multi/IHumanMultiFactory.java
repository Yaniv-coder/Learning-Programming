package com.yan.study.designpattern.factorymethod.multi;

import com.yan.study.designpattern.factorymethod.domain.IHuman;

/**
 * 多工厂生产人类接口.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:53
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public interface IHumanMultiFactory {
    /**
     * 根据需求制造人类.
     * @return 生产出来的人类
     */
    IHuman createHuman();
}
