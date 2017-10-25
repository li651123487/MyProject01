package com.example.logindemo1.presenter;

import android.content.Context;

import com.example.logindemo1.bean.UserBean;
import com.example.logindemo1.constract.LoginConstract;
import com.example.logindemo1.model.LoginModel;

/**
 * Created by Mr.Li on 2017\10\20 0020.
 * 说明：
 */

public class LoginPresenter implements LoginConstract.ILoginPresenter {

    private LoginConstract.ILoginView view;
    private LoginModel model;

    public LoginPresenter(LoginConstract.ILoginView view, Context context) {
        this.view = view;
        model = new LoginModel(context);

    }

    @Override
    public void login(UserBean userBean) {

        String username = view.getData().getUsername().toString().trim();
        String password = view.getData().getPassword().toString().trim();
        userBean.setUsername(username);
        userBean.setPassword(password);
        boolean isChecked = view.getData().isChecked();
        if (isChecked){
            model.saveUserBean(userBean);
        }
    }
}
