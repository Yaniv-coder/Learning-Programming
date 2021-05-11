package com.yan.study.designpattern.factorymethod.simple;

import com.yan.study.designpattern.factorymethod.domain.IHuman;

/**
 * 制造人类的简单工厂（静态工厂）.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:44
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public final class HumanSimpleFactory {
    /**
     * 禁止创建该对象实例.
     */
    private HumanSimpleFactory() {
    }

    public static <T extends IHuman> T createHuman(final Class<T> humanClass) {
        IHuman human = null;
        try {
            human = (IHuman) Class.forName(humanClass.getName()).getDeclaredConstructor().newInstance();
            System.out.println("对创建的对象进行复杂的初始化...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) human;
    }
}
