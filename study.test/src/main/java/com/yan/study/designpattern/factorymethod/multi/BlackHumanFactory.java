package com.yan.study.designpattern.factorymethod.multi;

import com.yan.study.designpattern.factorymethod.domain.BlackHuman;
import com.yan.study.designpattern.factorymethod.domain.IHuman;

/**
 * 黑人工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 23:56
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BlackHumanFactory implements IHumanMultiFactory {
    /**
     * 制造黑人.
     *
     * @return 生产出来的人类
     */
    @Override
    public IHuman createHuman() {
        System.out.println("创建黑人复杂的过程...");
        return new BlackHuman();
    }
}
