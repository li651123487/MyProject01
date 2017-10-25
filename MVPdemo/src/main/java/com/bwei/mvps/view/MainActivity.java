package com.bwei.mvps.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwei.mvps.R;
import com.bwei.mvps.presenter.UserPresenter;
import com.bwei.mvps.view.UserView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UserView {

    private EditText et_id;
    private EditText et_first_name;
    private EditText et_last_name;
    private Button bt_login;
    private Button bt_register;
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //找控件
        et_id = (EditText) findViewById(R.id.et_id);
        et_first_name = (EditText) findViewById(R.id.et_first_name);
        et_last_name = (EditText) findViewById(R.id.et_last_name);
        bt_login = (Button) findViewById(R.id.bt_login);
        bt_register = (Button) findViewById(R.id.bt_register);

        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        //声明UserPresenter
        userPresenter = new UserPresenter(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_register://保存数据
                userPresenter.saveUser(getId(), getFirstName(), getLastName());
                break;
            case R.id.bt_login:
                userPresenter.find(getId());
                break;
        }
    }

    @Override
    public void setFirstName(String firstName) {

        et_first_name.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {

        et_last_name.setText(lastName);
    }

    @Override
    public int getId() {

        return new Integer(et_id.getText().toString());
    }

    @Override
    public String getFirstName() {

        return et_first_name.getText().toString();
    }

    @Override
    public String getLastName() {

        return et_last_name.getText().toString();
    }
}
