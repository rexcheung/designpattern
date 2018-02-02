package com.zxbin.designpattern.dagger;

/**
 * Created by zxbin on 2018/2/2.
 */

public class StringBean {
    public String msg = "默认构造函数";

    public StringBean() {
    }

    public StringBean(String msg) {
        this.msg = msg;
    }
}
