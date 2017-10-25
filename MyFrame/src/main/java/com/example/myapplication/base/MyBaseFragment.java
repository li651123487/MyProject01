package com.example.myapplication.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Mr.Li on 2017/9/13.
 */

public abstract class MyBaseFragment<T> extends Fragment {

    protected Context mContext;
    protected T activity;

    public MyBaseFragment() {
    }

    public abstract View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState);

    @Override
    public void onStart() {
        getViewInfo();
        setListener();
        getInfo();
        super.onStart();
    }

    @Override
    public void onAttach(Activity activity) {
        mContext = activity.getApplicationContext();
        this.activity = (T)activity;
        super.onAttach(activity);
    }

    /*
	 * 获取view信息
	 */
    protected abstract void getViewInfo();

    /*
     * 设置监听
     */
    protected abstract void setListener();

    /*
     * 添加数据
     */
    protected abstract void getInfo();
}
