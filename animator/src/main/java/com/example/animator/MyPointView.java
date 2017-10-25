package com.example.animator;

import android.animation.PointFEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Mr.Li on 2017\10\14 0014.
 * 说明：
 */

public class MyPointView extends View{

    private float radius=100;
    private Paint paint;
    private MyPoint currentPoint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint == null){
            currentPoint = new MyPoint(radius,radius);
            drawCirle(canvas);
            startAnimator();
        }else {
            drawCirle(canvas);
        }

    }

    private void drawCirle(Canvas canvas){
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x,y,radius,paint);
    }
    private void startAnimator(){
        MyPoint starPoint = new MyPoint(radius,radius);
        MyPoint endPoint = new MyPoint(getWidth()-radius,getHeight()-radius);
        ValueAnimator animator = ValueAnimator.ofObject(new PontEvaluator(),starPoint,endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                currentPoint=(MyPoint)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(5000);
        animator.start();
    }
    public MyPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyPointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public MyPointView(Context context) {
        super(context);
        init();
    }

    private void init(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
    }
}
