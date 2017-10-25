package com.example.myapplication.base;

import android.app.Application;

import java.util.WeakHashMap;

/**
 * Created by Mr.Li on 2017/9/13.
 */

public class MyApplication extends Application {

    public static MyApplication myApplication;
    public static WeakHashMap<String, Object> dataHolder = new WeakHashMap<String, Object>();


    private MyApplication() {

    }

    public static MyApplication getInstance() {
        synchronized (MyApplication.class) {
            myApplication = new MyApplication();
        }
        return myApplication;
    }
}
