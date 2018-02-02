package com.zxbin.designpattern.dagger;

/**
 * Created by zxbin on 2018/2/2.
 */

public class SecondBean {
    public String msg = "这是dagger的第二个bean";


    public SecondBean() {
    }

    public SecondBean(String msg) {
        this.msg = msg;
    }
}
