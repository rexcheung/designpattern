package com.zxbin.designpattern.dagger;

import android.content.Context;
import android.util.Log;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zxbin on 2018/2/2.
 */

@Module
public class BeginModule {

    Context mContext;

    public BeginModule(Context mContext) {
        this.mContext = mContext;
        Log.d("BeginModule", "有参构造函数");
    }

    @Provides
    StringBean getBean() {
        return new StringBean("有参构造函数。");
    }

    @Provides
    SecondBean getSecondBean() {
        return new SecondBean();
    }
}
