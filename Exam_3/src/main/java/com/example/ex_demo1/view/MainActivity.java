package com.example.ex_demo1.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.ex_demo1.R;
import com.example.ex_demo1.customview.ProgressBarView;

public class MainActivity extends AppCompatActivity {

    private ProgressBarView pbv;
    private int progress = 120;
    private int time = 5;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            time--;
            if (time == 0){
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
            }else {
                progress += 120;
                pbv.setProgress(progress);
                handler.sendEmptyMessageDelayed(0,1000);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView)findViewById(R.id.logo_img);
        pbv = (ProgressBarView)findViewById(R.id.my_progess);
        setAnimation(imageView);
        handler.sendEmptyMessage(0);
        pbv.setProgress(progress);
    }

    private void setAnimation(ImageView imageView) {
        ObjectAnimator trans = ObjectAnimator.ofFloat(imageView,"translationY",0f,300f).setDuration(1000);
        ObjectAnimator scalX = ObjectAnimator.ofFloat(imageView,"scaleX",1f,2f,1f).setDuration(1000);
        ObjectAnimator scalY = ObjectAnimator.ofFloat(imageView,"scaleY",1f,2f,1f).setDuration(1000);

        AnimatorSet setAnimatior = new AnimatorSet();
        setAnimatior.play(trans).before(scalX).before(scalY);
        setAnimatior.start();
    }
}
