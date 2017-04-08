package com.fengying.rx2test;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by huangjie on 2017/4/6.
 */

public class MyApp extends Application {
    private static Context context;
    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        LeakCanary.install(this);
        GreenDaoManager.getInstance();
    }
}
