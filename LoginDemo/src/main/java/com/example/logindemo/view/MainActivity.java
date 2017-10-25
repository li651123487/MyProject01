package com.example.logindemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.logindemo.R;
import com.example.logindemo.bean.UserBean;
import com.example.logindemo.constract.LoginConstract;
import com.example.logindemo.presenter.LoginPresenter;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginConstract.ILoginView{

    private EditText et_name,et_pwd;
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
        presenter.showUser();
    }

    @Override
    public void onClick(View view) {

        presenter.login();
    }


    @Override
    public String getUsername() {
        return et_name.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_pwd.getText().toString().trim();
    }

    @Override
    public boolean isChecked() {
        return save.isChecked();
    }

    @Override
    public void showUser(UserBean user) {

        et_name.setText(user.getUsername());
        et_pwd.setText(user.getPassword());
    }

    @Override
    public void setCheckState(boolean state) {

        save.setChecked(state);
    }
}
