package com.yan.study.designpattern.abstractfactory.domain;

/**
 * 黑人女性.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 22:55
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BlackFemaleHuman extends AbstractBlackHuman {
    /**
     * 性别.
     */
    @Override
    public void getSex() {
        System.out.println("黑人女性");
    }
}
