package com.yan.study.designpattern.proxy.extend.dynamic;

/**
 * 前置通知.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 20:23
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BeforeAdvice implements IAdvice {
    /**
     * 执行增强方法.
     */
    @Override
    public void exec() {
        System.out.println("前置增强通知...");
    }
}
