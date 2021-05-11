package com.yan.study.designpattern.builder.basic;

import com.yan.study.designpattern.builder.domain.AbstractCarModel;
import com.yan.study.designpattern.builder.domain.BenzCarModel;
import com.yan.study.designpattern.builder.domain.CarRunStatusEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * 奔驰车模型建造者.
 *
 * @author: YanJiaqi
 * @date: 2021/4/17 0017 0:02
 * @version: 1.0
 * @since: JDK 11.0.9
 */
public class BenzCarModelBuilder extends AbstractCarBuilder {
    /**
     * 执行顺序.
     */
    private AbstractCarModel benzCarModel = new BenzCarModel();

    /**
     * 设置执行顺序.
     *
     * @param sequences 执行顺序
     */
    @Override
    public void setSequences(final List<CarRunStatusEnum> sequences) {
        this.benzCarModel.setSequences(sequences);
    }

    /**
     * 获取汽车模型.
     *
     * @return 汽车模型
     */
    @Override
    public AbstractCarModel getCarModel() {
        return this.benzCarModel;
    }
}
