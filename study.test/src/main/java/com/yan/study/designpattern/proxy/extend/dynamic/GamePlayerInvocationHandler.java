package com.yan.study.designpattern.proxy.extend.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 游戏玩家的调用处理器.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 19:31
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class GamePlayerInvocationHandler implements InvocationHandler {
    /**
     * 被代理对象.
     */
    private Object obj = null;

    /**
     * 构造方法.
     * @param obj 被代理对象
     */
    public GamePlayerInvocationHandler(final Object obj) {
        this.obj = obj;
    }

    /**
     * 处理在代理实例中调用的方法，并返回其结果.
     *
     * @param proxy  对其方法调用的代理实例
     * @param method 对应于代理类调用的接口方法.
     * @param args   方法参数.
     * @return 代理实例调用的方法的返回值.
     * @throws Throwable 调用的方法抛出的异常.
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final Object result = method.invoke(this.obj, args);
        System.out.println("有人用你账号登录...");
        return result;
    }
}
