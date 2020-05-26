package com.yiwa.myframework.bean;


/**
 * 返回数据对象
 */
public class Date {
    /**
     * 模型数据
     */
    private Object model;

    public Date(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
