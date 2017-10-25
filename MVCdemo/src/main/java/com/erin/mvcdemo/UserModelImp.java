package com.erin.mvcdemo;

/**
 * Created by mamiaomiao on 2017/9/13.
 */

public class UserModelImp implements UserModel {
    @Override
    public void setUser(String name, OnUserListner listner) {
        //从网络请求数据，获取。。。从数据库获取，，，
        UserBean userBean=new UserBean(name);
        if(userBean==null){
            listner.error();
        }else
            listner.success(userBean);

    }

    @Override
    public void getInfo() {

    }

    @Override
    public void getConnect() {

    }
}
