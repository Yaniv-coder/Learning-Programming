package com.yan.study.designpattern.abstractfactory.domain;

/**
 * 黑人男性.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 22:54
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BlackMaleHuman extends AbstractBlackHuman {
    /**
     * 性别.
     */
    @Override
    public void getSex() {
        System.out.println("黑人男性");
    }
}
