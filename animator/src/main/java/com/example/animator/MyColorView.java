package com.example.animator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Mr.Li on 2017\10\14 0014.
 * 说明：
 */

public class MyColorView extends View{

    private String color;
    private Paint paint;
    private float radius=100;
    private MyPoint currentPoint;

    public String getColor() {
        return color;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(currentPoint == null){
            currentPoint = new MyPoint(radius,radius);
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas){

        float x=currentPoint.getX();
    }
    public void setColor(String color) {
        this.color = color;
        paint.setColor(Color.parseColor(color));
        invalidate();
    }


    public MyColorView(Context context) {
        super(context);
        init();
    }

    public MyColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);//ANTI_ALIAS_FLAG 抗锯齿属性
        paint.setColor(Color.BLUE);
    }

}
