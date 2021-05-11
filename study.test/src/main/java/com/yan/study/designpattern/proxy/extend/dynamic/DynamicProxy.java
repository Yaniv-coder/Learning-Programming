package com.yan.study.designpattern.proxy.extend.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 20:15
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class DynamicProxy<T> {
    /**
     * 新建代理实例.
     * @param classLoader 被代理对象的类加载器
     * @param interfaces 被代理对象实现的所有接口集合
     * @param invocationHandler 调用处理器
     * @param <T> 返回值类型
     * @return
     */
    public static <T> T newProxyInstance(ClassLoader classLoader, Class[] interfaces, InvocationHandler invocationHandler) {
        // 寻找JoinPoint连接点
        if (true) {
            // 增强通知
            new BeforeAdvice().exec();
        }
        return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
