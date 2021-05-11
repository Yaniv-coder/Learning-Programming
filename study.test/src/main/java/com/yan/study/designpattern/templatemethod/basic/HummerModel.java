package com.yan.study.designpattern.templatemethod.basic;

/**
 * 悍马汽车抽象模型.
 *
 * @author: YanJiaqi
 * @date: 2021/4/13 0013 20:09
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public abstract class HummerModel {
    /**
     * 启动发动机.
     */
    abstract protected void start();

    /**
     * 关闭发动机.
     */
    abstract protected void stop();

    /**
     * 按喇叭.
     */
    abstract protected void alarm();

    /**
     * 跑动.
     */
    public void run() {
        this.start();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    /**
     * 喇叭是否会响.
     * @return 是否会响
     */
    protected boolean isAlarm() {
        return true;
    }
}
