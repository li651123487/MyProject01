package com.example.myapplication.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.utils.MySharedPreference;

/**
 * Created by Mr.Li on 2017/9/13.
 * AppCompatActivity相比较activity加入了actionbar
 */

public abstract class MyBaseActivity extends AppCompatActivity {

    protected MyApplication myApplication;
    protected Context mContext;
    protected MySharedPreference share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //不要忘了在调用的时候setContentView(R.layout.activity_main);
        //先布局在执行oncreat（）方法
        super.onCreate(savedInstanceState);

        mContext = this;
        share = MySharedPreference.getInstance(mContext);
        myApplication = MyApplication.getInstance();

        getView();
        setListener();
        getInfo();

    }

    /*
	 * 获取控件
	 */
    protected abstract void getView();

    /*
     * 设置监听
     */
    protected abstract void setListener();

    /*
     * 添加数据
     */
    protected abstract void getInfo();
}
