package com.example.logindemo1.constract;

import com.example.logindemo1.bean.UserBean;

/**
 * Created by Mr.Li on 2017\10\20 0020.
 * 说明：
 */

public class LoginConstract {

    public interface ILoginView{
        UserBean getData();

        void showData(UserBean userBean);
    }

    public interface ILoginModel{
        void saveUserBean(UserBean userBean);

        UserBean getUserBean();
    }

    public interface ILoginPresenter{
        void login(UserBean userBean);
    }
}
