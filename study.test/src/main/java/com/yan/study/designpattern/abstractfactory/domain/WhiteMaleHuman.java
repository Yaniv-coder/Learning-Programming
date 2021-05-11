package com.yan.study.designpattern.abstractfactory.domain;

/**
 * 白人男性.
 *
 * @author: YanJiaqi
 * @date: 2021/4/11 0011 22:58
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class WhiteMaleHuman extends AbstractWhiteHuman {

    /**
     * 性别.
     */
    @Override
    public void getSex() {
        System.out.println("白人男性");
    }
}
