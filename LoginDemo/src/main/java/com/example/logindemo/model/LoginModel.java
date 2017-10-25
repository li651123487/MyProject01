package com.example.logindemo.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.logindemo.bean.UserBean;
import com.example.logindemo.constract.LoginConstract;

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
    public void saveUser(String username, String password) {

        if (isEmpty(username) || isEmpty(password)){
            Toast.makeText(context,"请输入用户名密码",2000).show();
        }else {
            sp.edit().putString("name",username).putString("pwd",password).commit();
            Toast.makeText(context,"保存成功",2000).show();
        }

    }

    //从sp中取数据
    @Override
    public UserBean getUser() {


        String username = sp.getString("name","");
        String password = sp.getString("pwd","");
        if (isEmpty(username) || isEmpty(password)){
            return null;
        }else {
            UserBean userBean = new UserBean();
            userBean.setUsername(username);
            userBean.setPassword(password);
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
