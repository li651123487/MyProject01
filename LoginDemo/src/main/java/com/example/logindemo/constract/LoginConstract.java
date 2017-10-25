package com.example.logindemo.constract;

import com.example.logindemo.bean.UserBean;

import static android.R.attr.password;

/**
 * Created by Mr.Li on 2017\10\20 0020.
 * 说明：
 */

public class LoginConstract {

    //view接口
    public interface ILoginView{

        //获取前台控件值
        String getUsername();
        String getPassword();
        boolean isChecked();//获取选中状态

        //前台赋值
        void showUser(UserBean user);
        void setCheckState(boolean state);
    }

    public interface ILoginModel{

        void saveUser(String username,String password);
        UserBean getUser();
    }

    public interface ILoginPresenter{

        void showUser();

        void login();
    }
}
