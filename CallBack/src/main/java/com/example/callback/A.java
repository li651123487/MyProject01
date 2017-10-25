package com.example.callback;

/**
 * Created by Mr.Li on 2017\10\12 0012.
 * 说明：
 */

public class A implements CallBack{
    /**
     * B类引用
     */
    private B b;

    public A(B b){
        this.b = b;
    }

    /**
     * A类通过该方法调用B的方法C（可理解为找到厨师并将面粉给他）。
     */
    public void selectMenu(){
        b.C(this);
    }

    /**
     * A类中的D方法，也称为A类的回调方法（厨师做好包子将包子（result）返回给顾客A）
     */
    @Override
    public void Eat(String result) {
        System.out.print(result);
    }
}
