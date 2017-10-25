package com.example.logindemo.presenter;

import android.content.Context;

import com.example.logindemo.bean.UserBean;
import com.example.logindemo.constract.LoginConstract;
import com.example.logindemo.model.LoginModel;

/**
 * Created by Mr.Li on 2017\10\20 0020.
 * 说明：
 */

public class LoginPresenter implements LoginConstract.ILoginPresenter{

    private LoginConstract.ILoginView view;
    private LoginModel loginModel;

    public LoginPresenter(LoginConstract.ILoginView view, Context context) {
        this.view = view;
        loginModel = new LoginModel(context);
    }

    @Override
    public void showUser() {
        UserBean userBean = loginModel.getUser();
        if (userBean != null){
            view.showUser(userBean);
            view.setCheckState(true);
        }else {
            view.setCheckState(false);
        }

    }

    @Override
    public void login() {

        String username = view.getUsername();
        String password = view.getPassword();
        boolean isChecked = view.isChecked();
        if (isChecked){
            loginModel.saveUser(username,password);
        }
    }
}
