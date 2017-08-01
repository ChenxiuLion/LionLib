package com.sec.health.health.base;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by chenxiu on 2017/7/18.
 * Success is getting what you want
 * 爱生活，爱撸码，我为自己代言。
 */

public class ReApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
