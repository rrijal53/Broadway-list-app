package com.rowsun.noticeapp;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}