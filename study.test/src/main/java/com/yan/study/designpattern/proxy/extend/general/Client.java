package com.yan.study.designpattern.proxy.extend.general;

import com.yan.study.designpattern.proxy.basic.GamePlayer;

/**
 * 普通代理模式场景类（用户知道代理的存在，但不知道代理具体调用哪一个真实角色）.
 *
 * @author: YanJiaqi
 * @date: 2021/4/18 0018 1:09
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final IGamePlayer proxy = new GamePlayerProxy("张三");
        proxy.play("zhangsan", "abcd1234");
    }
}
