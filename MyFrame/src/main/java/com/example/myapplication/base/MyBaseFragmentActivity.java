package com.example.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.example.myapplication.utils.MySharedPreference;

/**
 * Created by Mr.Li on 2017/9/13.
 */

public abstract class MyBaseFragmentActivity extends FragmentActivity {

    protected MyApplication myApplication;
    protected Context mContext;
    private MySharedPreference sharedPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
        sharedPreference = MySharedPreference.getInstance(mContext);
        myApplication = MyApplication.getInstance();
    }
}
