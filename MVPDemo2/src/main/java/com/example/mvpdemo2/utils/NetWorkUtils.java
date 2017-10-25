package com.example.mvpdemo2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Mr.Li on 2017\10\19 0019.
 * 说明：
 */

public class NetWorkUtils {

    public static boolean IsNetWorkAvailable(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null){
            return true;
        }
        return false;
    }
}
