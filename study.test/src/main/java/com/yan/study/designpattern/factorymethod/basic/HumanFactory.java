package com.yan.study.designpattern.factorymethod.basic;

import com.yan.study.designpattern.factorymethod.domain.IHuman;

/**
 * 具体的人类制造工厂.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:35
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class HumanFactory implements IHumanFactory {
    /**
     * 根据需求制造人类.
     *
     * @param humanClass 指定要生产的人种
     * @return 生产出来的人类
     */
    @Override
    public <T extends IHuman> T createHuman(final Class<T> humanClass) {
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
