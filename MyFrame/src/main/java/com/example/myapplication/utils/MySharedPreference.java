package com.example.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mr.Li on 2017/9/13.
 */

public class MySharedPreference {
    private static MySharedPreference instance;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public MySharedPreference() {

    }

    public static MySharedPreference getInstance(Context context) {
        synchronized (MySharedPreference.class) {
            instance = new MySharedPreference();
            sharedPreferences = context.getSharedPreferences("text", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
        return instance;
    }

//    /*
//	 * 保存用户是否自动登录状态
//	 */
//    public void setLoginAuto(Boolean isAuto) { // false表示不自动登录
//        editor.putBoolean("isAuto", isAuto);
//        editor.commit();
//    }
}
