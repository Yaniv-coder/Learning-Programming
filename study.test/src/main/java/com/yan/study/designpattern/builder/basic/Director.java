package com.yan.study.designpattern.builder.basic;

import com.yan.study.designpattern.builder.domain.BenzCarModel;
import com.yan.study.designpattern.builder.domain.CarRunStatusEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 导演类.
 *
 * @author: YanJiaqi
 * @date: 2021/4/17 0017 0:09
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class Director {
    /**
     * 执行顺序.
     */
    private List<CarRunStatusEnum> sequences = new ArrayList<>();
    /**
     * 奔驰车建造者.
     */
    private AbstractCarBuilder benzBuilder = new BenzCarModelBuilder();

    /**
     * 获取A类奔驰车.
     * @return A类奔驰车
     */
    public BenzCarModel getABenzCarModel() {
        this.sequences.clear();
        this.sequences.add(CarRunStatusEnum.START);
        this.sequences.add(CarRunStatusEnum.ALARM);
        this.sequences.add(CarRunStatusEnum.STOP);
        benzBuilder.setSequences(this.sequences);
        return (BenzCarModel) benzBuilder.getCarModel();
    }

    /**
     * 获取B类奔驰车.
     * @return B类奔驰车
     */
    public BenzCarModel getBBenzCarModel() {
        this.sequences.clear();
        this.sequences.add(CarRunStatusEnum.START);
        this.sequences.add(CarRunStatusEnum.STOP);
        this.sequences.add(CarRunStatusEnum.ALARM);
        benzBuilder.setSequences(this.sequences);
        return (BenzCarModel) benzBuilder.getCarModel();
    }
}
