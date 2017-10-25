package com.example.callback;


/**
 * Created by Mr.Li on 2017\10\12 0012.
 * 说明：
 */

public class B {

    /**
     * B类的C方法（接受面粉Callback,然后开工做包子，做好后返回给客户A）。
     */
    public void C(CallBack callback){
        String result = "2";
        callback.Eat(result);
    }
}
