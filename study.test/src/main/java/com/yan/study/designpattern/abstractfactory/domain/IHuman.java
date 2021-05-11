package com.yan.study.designpattern.abstractfactory.domain;

/**
 * 人类接口.
 *
 * @author: YanJiaqi
 * @date: 2021/4/8 0008 20:26
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public interface IHuman {
    /**
     * 肤色.
     */
    void getColor();

    /**
     * 说话.
     */
    void talk();

    /**
     * 性别.
     */
    void getSex();
}
