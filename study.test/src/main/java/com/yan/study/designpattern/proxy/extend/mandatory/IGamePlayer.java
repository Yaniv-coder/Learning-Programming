package com.yan.study.designpattern.proxy.extend.mandatory;

/**
 * 游戏玩家接口.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 18:48
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public interface IGamePlayer {
    /**
     * 登录。
     * @param account 账号
     * @param password 密码
     */
    void login(String account, String password);

    /**
     * 升级.
     */
    void upgrade();

    /**
     * 游玩.
     * @param account 账号
     * @param password 密码
     */
    void play(String account, String password);

    /**
     * 获取代理对象.
     * @return 代理对象
     */
    IGamePlayer getProxy();
}
