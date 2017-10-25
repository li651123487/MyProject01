package com.example.mvpdemo2.utils;

import android.os.Environment;
import android.os.Handler;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Mr.Li on 2017\10\19 0019.
 * 说明：
 */

public class OKHttp3Utils {

    private static OKHttp3Utils okHttpUtils = null;

    public OKHttp3Utils() {
    }
    public static OKHttp3Utils getInstence(){
        if (okHttpUtils == null){
            synchronized (OKHttp3Utils.class){
                if (okHttpUtils == null){
                    okHttpUtils = new OKHttp3Utils();
                }
            }
        }
        return okHttpUtils;

    }

    private static OkHttpClient okHttpClient = null;
    public synchronized static OkHttpClient getOkHttpClient(){
        if (okHttpClient == null){
            File sdche = new File(Environment.getExternalStorageDirectory(),"cache");
            int cacheSize = 10 * 1024 * 1024;//10M
            LoggingInterceptor interceptor = new LoggingInterceptor();
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .readTimeout(20,TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .cache(new Cache(sdche.getAbsoluteFile(),cacheSize))
                    .build();
        }
        return okHttpClient;
    }

    private static Handler handler = null;
    public synchronized static Handler getHandler(){
        if (handler == null){
            handler = new Handler();
        }
        return handler;
    }

    public static void doGet(URL url, Callback callback){
        OkHttpClient okHttpClient = getOkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
