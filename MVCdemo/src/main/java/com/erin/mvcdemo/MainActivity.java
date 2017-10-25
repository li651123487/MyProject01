package com.erin.mvcdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnUserListner{
private TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v=(TextView)findViewById(R.id.mytext);
        UserModelImp modelImp=new UserModelImp();
        modelImp.setUser("小红", new OnUserListner() {
            @Override
            public void success(UserBean user) {

            }

            @Override
            public void error() {

            }
        });
        modelImp.getConnect();
    }

    @Override
    public void success(UserBean user) {
        v.setText(user.name+"  "+user.age);
    }

    @Override
    public void error() {

    }
}
