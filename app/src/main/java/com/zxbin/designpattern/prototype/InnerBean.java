package com.zxbin.designpattern.prototype;

/**
 * Created by zxbin on 2018/2/12.
 */

public class InnerBean implements Cloneable{
    public String msg = "InnerBean";

    @Override
    protected InnerBean clone() throws CloneNotSupportedException {
        return (InnerBean) super.clone();
    }
}
