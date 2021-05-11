package com.yan.study.designpattern.templatemethod.basic;

/**
 * 模板方法模式场景.
 *
 * @author: YanJiaqi
 * @date: 2021/4/13 0013 21:42
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class
Client {
    public static void main(String[] args) {
        final HummerH1Model h1Model = new HummerH1Model();
        h1Model.setAlarmFlag(false);
        h1Model.run();

        final HummerH2Model h2Model = new HummerH2Model();
        h2Model.setAlarmFlag(true);
        h2Model.run();
    }
}
