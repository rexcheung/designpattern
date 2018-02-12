package com.zxbin.designpattern.prototype;

/**
 * Created by zxbin on 2018/2/12.
 */

public class CopyBean implements Cloneable {
    public InnerBean inner;

    public CopyBean() {
        inner = new InnerBean();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
