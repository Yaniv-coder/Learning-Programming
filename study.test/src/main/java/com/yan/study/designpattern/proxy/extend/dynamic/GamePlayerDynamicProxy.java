package com.yan.study.designpattern.proxy.extend.dynamic;

/**
 * 游戏玩家动态代理.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 20:39
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class GamePlayerDynamicProxy extends DynamicProxy<IGamePlayer> {
    /**
     * 新建游戏玩家的代理类.
     *
     * @param gamePlayer 要被代理的游戏玩家
     * @return 游戏玩家的代理类
     */
    public static IGamePlayer newProxyInstance(final IGamePlayer gamePlayer) {
        final Class<? extends IGamePlayer> clazz = gamePlayer.getClass();
        final ClassLoader classLoader = clazz.getClassLoader();
        final Class<?>[] interfaces = clazz.getInterfaces();
        final GamePlayerInvocationHandler invocationHandler = new GamePlayerInvocationHandler(gamePlayer);
        return newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
