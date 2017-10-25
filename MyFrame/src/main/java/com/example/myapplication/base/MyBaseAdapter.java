package com.example.myapplication.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Mr.Li on 2017/9/13.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected ArrayList<T> list;

    //构造方法
    public MyBaseAdapter(Context context) {

        mContext = context;
    }
    //父类的三个方法
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public abstract View getView(int position, View convertview, ViewGroup parent);


    public ArrayList<T> getData() {

        return list;
    }

    public void setData(ArrayList<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

}
