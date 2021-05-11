package com.yan.study.designpattern.proxy.extend.mandatory;


/**
 * 强制代理模式场景类.
 *
 * @author: YanJiaqi
 * @date: 2021/4/18 0018 1:09
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final IGamePlayer gamePlayer = new GamePlayer("张三");
        final IGamePlayer proxy = gamePlayer.getProxy();
        proxy.play("zhangsan", "1234");
    }
}
