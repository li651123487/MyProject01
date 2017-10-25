package com.bwei.mvps.model;

import android.util.Log;

import com.bwei.mvps.bean.UserBean;

/**
 * Created by Mr.Li on 2017\10\14 0014.
 * 说明：
 */

public class IUserModel implements UserModel {
    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public UserBean load(int id) {
        //查询数据库或联网获取数据
        Log.i("fff", id + "");

        return new UserBean("张", "三");
    }

    @Override
    public void setFirstName() {

    }

    @Override
    public void setLastName() {

    }
}
