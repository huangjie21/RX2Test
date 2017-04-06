package com.fengying.rx2test;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by huangjie on 2017/4/6.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
