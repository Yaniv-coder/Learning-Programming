package com.yan.study.designpattern.proxy.extend.general;

/**
 * 游戏角色代理.
 *
 * @author: YanJiaqi
 * @date: 2021/4/19 0019 0:42
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class GamePlayerProxy implements IGamePlayer, IProxy {
    /**
     * 被代理的游戏角色.
     */
    private IGamePlayer gamePlayer = null;

    /**
     * 通过游戏角色名称创建代理对象.
     * @param name 游戏角色名称
     */
    public GamePlayerProxy(final String name) {
        this.gamePlayer = new GamePlayer(this, name);
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
        this.count();
    }

    /**
     * 游玩.
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void play(String account, String password) {
        this.login(account, password);
        this.upgrade();
    }

    /**
     * 代理收费.
     */
    @Override
    public void count() {
        System.out.println("升一级收费50元...");
    }
}
