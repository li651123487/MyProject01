package com.bwei.mvps.model;

import com.bwei.mvps.bean.UserBean;

/**
 * Created by Mr.Li on 2017\10\14 0014.
 * 说明：
 */

public interface UserModel {

    String getFirstName();

    String getLastName();

    UserBean load(int id);

    void  setFirstName();

    void setLastName();
}
