package com.yan.study.designpattern.proxy.extend.dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理场景类.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 19:54
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("===============basicClient====================");
        basicClient();

        System.out.println("===============adviceClient====================");

        adviceClient();

        System.out.println("===============improveAdviceClient====================");
        improveAdviceClient();
    }

    private static void basicClient() {
        final IGamePlayer gamePlayer = new GamePlayer("张三");
        final Class<? extends IGamePlayer> cls = gamePlayer.getClass();
        final ClassLoader classLoader = cls.getClassLoader();
        final Class<?>[] interfaces = cls.getInterfaces();

        final IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, interfaces,
                new GamePlayerInvocationHandler(gamePlayer));
        proxy.play("zhangsan", "1234");
    }

    private static void adviceClient() {
        final IGamePlayer gamePlayer = new GamePlayer("李四");
        final Class<? extends IGamePlayer> cls = gamePlayer.getClass();
        final ClassLoader classLoader = cls.getClassLoader();
        final Class<?>[] interfaces = cls.getInterfaces();
        final IGamePlayer proxy = DynamicProxy.newProxyInstance(classLoader, interfaces, new GamePlayerInvocationHandler(gamePlayer));
        proxy.play("lisi", "1234");
    }

    private static void improveAdviceClient() {
        final IGamePlayer gamePlayer = new GamePlayer("王二");
        final IGamePlayer proxy = GamePlayerDynamicProxy.newProxyInstance(gamePlayer);
        proxy.play("wanger", "1234");
    }
}
