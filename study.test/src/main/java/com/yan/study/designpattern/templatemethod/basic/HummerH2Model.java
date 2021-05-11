package com.yan.study.designpattern.templatemethod.basic;

/**
 * 悍马H2模型.
 *
 * @author: YanJiaqi
 * @date: 2021/4/13 0013 20:23
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class HummerH2Model extends HummerModel {
    /**
     * 是否有喇叭的标志.
     */
    private boolean alarmFlag = false;

    /**
     * 启动发动机.
     */
    @Override
    protected void start() {
        System.out.println("H2发动机启动了...");
    }

    /**
     * 关闭发动机.
     */
    @Override
    protected void stop() {
        System.out.println("H2发动机关闭了...");
    }

    /**
     * 按喇叭.
     */
    @Override
    protected void alarm() {
        System.out.println("H2叭叭叭叭...");
    }

    @Override
    protected boolean isAlarm() {
        return alarmFlag;
    }

    /**
     * 设置是否有喇叭.
     * @param alarmFlag 是否有喇叭
     */
    public void setAlarmFlag(final boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
