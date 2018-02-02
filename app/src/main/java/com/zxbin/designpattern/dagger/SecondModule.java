package com.zxbin.designpattern.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zxbin on 2018/2/2.
 */

@Module
public class SecondModule {

    @Provides
    SecondBean getBean() {
        return new SecondBean();
    }
}
