package com.bwei.mvps.presenter;

import android.util.Log;

import com.bwei.mvps.bean.UserBean;
import com.bwei.mvps.model.IUserModel;
import com.bwei.mvps.view.UserView;

/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/1 16:05
 */

public class UserPresenter {

    private UserView userview;
    private final IUserModel UserModel;

    public UserPresenter(UserView userview) {
        this.userview = userview;
        UserModel = new IUserModel();

    }

    //保存数据
    public void saveUser(int id, String firstName, String lastName) {
        UserBean userBean = UserModel.load(id);
        Log.i("sss", "id:" + id + ",firstName:" + firstName + ",lastName:" + lastName);

    }

    //查询数据
    public void find(int id) {
        UserBean userBean = UserModel.load(id);
        String firstName = userBean.getFirstName();
        String lastName = userBean.getLastName();
        userview.setFirstName(firstName);
        userview.setLastName(lastName);

        Log.i("aaa", "id:" + id + ",firstName:" + firstName + ",lastName:" + lastName);

    }
}
