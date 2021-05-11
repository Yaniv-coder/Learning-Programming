package com.yan.study.designpattern.proxy.basic;

/**
 * 游戏者代理.
 *
 * @author: YanJiaqi
 * @date: 2021/4/18 0018 1:00
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class GamePlayerProxy implements IGamePlayer {
    /**
     * 被代理的游戏玩家.
     */
    private IGamePlayer gamePlayer = null;

    /**
     * 构造器.
     * @param gamePlayer 需要被代理的游戏玩家
     */
    public GamePlayerProxy(final IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    /**
     * 登录。
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void login(String account, String password) {
        this.gamePlayer.login(account, password);
    }

    /**
     * 升级.
     */
    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }

    /**
     * 游玩.
     *
     * @param account 账号
     * @param password 密码
     */
    @Override
    public void play(String account, String password) {
        this.gamePlayer.play(account, password);
    }
}
