package com.example.logindemo1.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.logindemo1.R;
import com.example.logindemo1.bean.UserBean;
import com.example.logindemo1.constract.LoginConstract;
import com.example.logindemo1.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginConstract.ILoginView{

    private EditText et_name;
    private EditText et_pwd;
    private CheckBox save;
    private Button login;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = (EditText)findViewById(R.id.et_name);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        save = (CheckBox) findViewById(R.id.save);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
        presenter = new LoginPresenter(MainActivity.this,this);
    }

    @Override
    public void onClick(View view) {
         presenter.login(getData());
    }

    @Override
    public UserBean getData() {
        UserBean userBean = new UserBean();
        userBean.setUsername(et_name.getText().toString().trim());
        userBean.setPassword(et_pwd.getText().toString().trim());
        userBean.setChecked(save.isChecked());
        return userBean;
    }

    @Override
    public void showData(UserBean userBean) {

        userBean.setUsername(et_name.getText().toString().trim());
        userBean.setPassword(et_pwd.getText().toString().trim());
        userBean.setChecked(save.isChecked());
    }
}
