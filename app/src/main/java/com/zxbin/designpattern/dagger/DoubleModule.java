package com.zxbin.designpattern.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zxbin on 2018/2/2.
 */

@Module
public class DoubleModule {

    @Provides
    StringBean get() {
        return new StringBean();
    }
}
