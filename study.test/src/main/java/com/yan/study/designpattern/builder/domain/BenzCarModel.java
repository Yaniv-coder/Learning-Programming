package com.yan.study.designpattern.builder.domain;

/**
 * 奔驰车模型.
 *
 * @author: YanJiaqi
 * @date: 2021/4/16 0016 23:38
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BenzCarModel extends AbstractCarModel {
    /**
     * 启动发动机.
     */
    @Override
    protected void start() {
        System.out.println("奔驰发动机启动了...");
    }

    /**
     * 关闭发动机.
     */
    @Override
    protected void stop() {
        System.out.println("奔驰发动机关闭了...");
    }

    /**
     * 按喇叭.
     */
    @Override
    protected void alarm() {
        System.out.println("奔驰叭叭叭叭...");
    }
}
