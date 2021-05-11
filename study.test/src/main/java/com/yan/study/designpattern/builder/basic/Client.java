package com.yan.study.designpattern.builder.basic;

import com.yan.study.designpattern.builder.domain.BenzCarModel;

/**
 * 建造者模式场景类.
 *
 * @author: YanJiaqi
 * @date: 2021/4/17 0017 0:21
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Client {
    public static void main(String[] args) {
        final Director director = new Director();
        final BenzCarModel aBenzCarModel = director.getABenzCarModel();
        aBenzCarModel.run();
        final BenzCarModel bBenzCarModel = director.getBBenzCarModel();
        bBenzCarModel.run();
    }
}
