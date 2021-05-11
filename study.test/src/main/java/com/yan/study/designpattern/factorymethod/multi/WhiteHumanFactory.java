package com.yan.study.designpattern.factorymethod.multi;

import com.yan.study.designpattern.factorymethod.domain.IHuman;
import com.yan.study.designpattern.factorymethod.domain.WhiteHuman;

/**
 * 白人工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 23:58
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class WhiteHumanFactory implements IHumanMultiFactory {
    /**
     * 制造白种人.
     *
     * @return 生产出来的人类
     */
    @Override
    public IHuman createHuman() {
        System.out.println("创建白人复杂的过程...");
        return new WhiteHuman();
    }
}
