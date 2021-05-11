package com.yan.study.designpattern.factorymethod.multi;

import com.yan.study.designpattern.factorymethod.domain.IHuman;
import com.yan.study.designpattern.factorymethod.domain.YellowHuman;

/**
 * 黄人工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 23:59
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class YellowHumanFactory implements IHumanMultiFactory {
    /**
     * 制造黄种人.
     *
     * @return 生产出来的人类
     */
    @Override
    public IHuman createHuman() {
        System.out.println("创建黄人复杂的过程...");
        return new YellowHuman();
    }
}
