package com.zxbin.designpattern.dagger;

import dagger.Component;

/**
 * Created by zxbin on 2018/2/2.
 */

@Component(modules = {BeginModule.class})
public interface BeginComponent {
    void inject(DaggerBeginActivity activity);
}
