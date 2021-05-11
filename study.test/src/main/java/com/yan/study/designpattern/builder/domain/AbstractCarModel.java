package com.yan.study.designpattern.builder.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 汽车模型.
 *
 * @author: YanJiaqi
 * @date: 2021/4/13 0013 23:53
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public abstract class AbstractCarModel {
    /**
     * 组装顺序.
     */
    private List<CarRunStatusEnum> sequences = new ArrayList<>();

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
     * 按执行顺序来进行跑动.
     */
    public void run() {
        sequences.forEach(runStatusEnum -> {
            if (CarRunStatusEnum.START == runStatusEnum) {
                this.start();
            } else if (CarRunStatusEnum.STOP == runStatusEnum) {
                this.stop();
            } else if (CarRunStatusEnum.ALARM == runStatusEnum) {
                this.alarm();
            }
        });
    }

    /**
     * 设置执行顺序.
     * @param sequences 执行顺序
     */
    public void setSequences(final List<CarRunStatusEnum> sequences) {
        this.sequences = sequences;
    }

    /**
     * 获取执行顺序.
     * @return 执行顺序
     */
    public List<CarRunStatusEnum> getSequences() {
        return sequences;
    }
}
