package com.zxbin.designpattern.prototype;

/**
 * Created by zxbin on 2018/2/12.
 */

public class InnerBean implements Cloneable{
    public String msg = "InnerBean";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
