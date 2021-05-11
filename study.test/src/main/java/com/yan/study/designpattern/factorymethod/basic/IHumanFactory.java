package com.yan.study.designpattern.factorymethod.basic;

import com.yan.study.designpattern.factorymethod.domain.IHuman;

/**
 * 人类制造工厂接口.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:32
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public interface IHumanFactory {
    /**
     * 根据需求制造人类.
     * @param humanClass 指定要生产的人种
     * @param <T> 生产的具体人类
     * @return 生产出来的人类
     */
    <T extends IHuman> T createHuman(Class<T> humanClass);
}
