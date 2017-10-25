package com.example.logindemo1.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.logindemo1.bean.UserBean;
import com.example.logindemo1.constract.LoginConstract;


/**
 * Created by Mr.Li on 2017\10\20 0020.
 * 说明：
 */

public class LoginModel implements LoginConstract.ILoginModel {

    private SharedPreferences sp;
    private Context context;

    public LoginModel(Context context) {
        this.context = context;
        sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    @Override
    public void saveUserBean(UserBean userBean) {

        if (isEmpty(userBean.getUsername()) || isEmpty(userBean.getPassword())){
            Toast.makeText(context,"请输入用户名和密码",2000).show();
        }else {
            sp.edit()
                    .putString("username",userBean.getUsername())
                    .putString("password",userBean.getPassword())
                    .putBoolean("isChecked",userBean.isChecked())
                    .commit();
            Toast.makeText(context,"保存成功",2000).show();
        }

    }

    @Override
    public UserBean getUserBean() {
        String username = sp.getString("username",null);
        String password = sp.getString("password",null);
        boolean isChecked = sp.getBoolean("isChecked",false);
        if (isEmpty(username) || isEmpty(password)){
//            CheckBox.inflate()
            return null;
        }else {
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);
            userBean.setChecked(isChecked);
            return userBean;
        }
    }
    public boolean isEmpty(String data){
        if (data == null || data.equals("")){
            return true;
        }
        return false;
    }
}
