package com.yan.study.designpattern.proxy.basic;

/**
 * 游戏玩家接口.
 *
 * @author: YanJiaqi
 * @date: 2021/4/18 0018 0:45
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
}
