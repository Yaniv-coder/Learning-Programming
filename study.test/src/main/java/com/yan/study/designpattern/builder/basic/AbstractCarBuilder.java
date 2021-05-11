package com.yan.study.designpattern.builder.basic;

import com.yan.study.designpattern.builder.domain.AbstractCarModel;
import com.yan.study.designpattern.builder.domain.CarRunStatusEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象汽车建造者.
 *
 * @author: YanJiaqi
 * @date: 2021/4/16 0016 23:51
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public abstract class AbstractCarBuilder {
    /**
     * 设置执行顺序.
     * @param sequences
     */
    abstract public void setSequences(final List<CarRunStatusEnum> sequences);

    /**
     * 获取汽车模型.
     * @return 汽车模型
     */
    abstract public AbstractCarModel getCarModel();
}
