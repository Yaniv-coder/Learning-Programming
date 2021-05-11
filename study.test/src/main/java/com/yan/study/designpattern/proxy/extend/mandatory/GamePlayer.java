package com.yan.study.designpattern.proxy.extend.mandatory;


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
     * 游戏代理（强制）.
     */
    private IGamePlayer proxy = null;

    /**
     * 游戏昵称.
     */
    private String name = null;

    /**
     * 构造器.
     * @param name 游戏昵称
     */
    public GamePlayer(final String name) {
        this.name = name;
    }

    /**
     * 登录。
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void login(final String account, final String password) {
        if (isProxy()) {
            System.out.println("登录名为" + account + "的用户" + this.name + "已经登陆成功！");
        } else {
            System.out.println("必须通过代理。");
        }
    }

    /**
     * 升级.
     */
    @Override
    public void upgrade() {
        if (isProxy()) {
            System.out.println(this.name + "打怪升级了！");
        } else {
            System.out.println("必须通过代理。");
        }
    }

    /**
     * 游玩.
     *
     * @param account  账号
     * @param password 密码
     */
    @Override
    public void play(final String account, final String password) {
        if (isProxy()) {
            this.login(account, password);
            this.upgrade();
        } else {
            System.out.println("必须通过代理。");
        }
    }

    /**
     * 获取代理对象.
     *
     * @return 代理对象
     */
    @Override
    public IGamePlayer getProxy() {
        if (null == proxy) {
            this.proxy = new GamePlayerProxy(this);
        }

        return this.proxy;
    }

    /**
     * 判断是否为代理类访问.
     * @return 是否为代理类访问
     */
    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }
}
