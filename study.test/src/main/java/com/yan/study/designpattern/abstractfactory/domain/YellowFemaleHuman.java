package com.yan.study.designpattern.abstractfactory.domain;

/**
 * 黄人女性.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 23:01
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class YellowFemaleHuman extends AbstractYellowHuman {
    /**
     * 性别.
     */
    @Override
    public void getSex() {
        System.out.println("黄人女性");
    }
}
