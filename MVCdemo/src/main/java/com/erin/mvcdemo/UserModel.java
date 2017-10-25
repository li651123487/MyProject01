package com.erin.mvcdemo;

/**
 * Created by mamiaomiao on 2017/9/13.
 */

public interface UserModel {
    void setUser(String name,OnUserListner listner);
    void getInfo();
    void getConnect();
}
