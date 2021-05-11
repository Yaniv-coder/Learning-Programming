package com.yan.study.designpattern.proxy.extend.mandatory;

/**
 * 游戏玩家代理.
 *
 * @author: YanJiaqi
 * @date: 2021/4/21 0021 18:58
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class GamePlayerProxy implements IGamePlayer {
    /**
     * 被代理的游戏玩家.
     */
    private IGamePlayer gamePlayer = null;

    /**
     * 构造方法.
     * @param gamePlayer 要代理的游戏玩家
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
        System.out.println("你的账号正在登录...");
    }

    /**
     * 升级.
     */
    @Override
    public void upgrade() {
        System.out.println("代理额外服务...");
        this.gamePlayer.upgrade();
    }

    /**
     * 游玩.
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void play(String account, String password) {
        System.out.println("代理额外服务...");
        this.gamePlayer.play(account, password);
    }

    /**
     * 获取代理对象（该代理没有上级代理了）.
     *
     * @return 代理对象
     */
    @Override
    public IGamePlayer getProxy() {
        return this;
    }
}
