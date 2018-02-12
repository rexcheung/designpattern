package com.zxbin.designpattern.prototype;

/**
 * Created by zxbin on 2018/2/12.
 */

public class CopyBean implements Cloneable {
    public InnerBean inner;
    public InnerBean inner1;
    public InnerBean inner2;
    public InnerBean inner3;
    public InnerBean inner4;

    public CopyBean() {
        inner = new InnerBean();
        inner1 = new InnerBean();
        inner2 = new InnerBean();
        inner3 = new InnerBean();
        inner4 = new InnerBean();
    }

    @Override
    protected CopyBean clone() throws CloneNotSupportedException {
        CopyBean bean = (CopyBean) super.clone();
        bean.inner=inner.clone();
        bean.inner1=inner1.clone();
        bean.inner2=inner2.clone();
        bean.inner3=inner3.clone();
        bean.inner4=inner4.clone();
        return bean;
    }
}
