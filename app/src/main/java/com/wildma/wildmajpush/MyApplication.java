package com.wildma.wildmajpush;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        JPushInterface.setDebugMode(true);//设置极光推送开启日志,发布时请关闭日志
        JPushInterface.init(this);//初始化极光推送
    }
}
