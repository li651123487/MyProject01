package com.example.logindemo.bean;

/**
 * Created by Mr.Li on 2017\10\20 0020.
 * 说明：
 */

public class UserBean {

    private String username;
    private String password;
    private String isChecked;

    public String getIsCheck() {
        return isChecked;
    }

    public void setIsCheck(String isCheck) {
        this.isChecked = isCheck;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
