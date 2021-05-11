package com.yan.study.designpattern.proxy.extend.general;
/**
 * 具体游戏者.
 *
 * @author: YanJiaqi
 * @date: 2021/4/18 0018 0:58
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class GamePlayer implements IGamePlayer {
    /**
     * 游戏昵称.
     */
    private String name = null;

    /**
     * 构造器.
     * @param gamePlayer 谁能创建真实对象
     * @param name 游戏昵称
     */
    public GamePlayer(final IGamePlayer gamePlayer, final String name) {
        if (gamePlayer == null) {
            System.out.println("需要能创建真实对象的对象调用...");
        } else {
            this.name = name;
        }
    }

    /**
     * 登录。
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void login(final String account, final String password) {
        System.out.println("登录名为" + account + "的用户" + this.name + "已经登陆成功！");
    }

    /**
     * 升级.
     */
    @Override
    public void upgrade() {
        System.out.println(this.name + "打怪升级了！");
    }

    /**
     * 游玩.
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void play(final String account, final String password) {
        this.login(account, password);
        this.upgrade();
    }
}
