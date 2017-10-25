package com.example.mvpdemo2.utils;


import android.os.Handler;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Mr.Li on 2017\10\19 0019.
 * 说明：
 */

public abstract class GsonArrayCallBack<T> implements Callback {

    private Handler handler = OKHttp3Utils.getInstence().getHandler();

    public abstract  void onUi(List<T> list);
    public abstract void onFailed(Call call,IOException e);
    @Override
    public void onFailure(final Call call, final IOException e) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailed(call,e);
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        final List<T> list = new ArrayList<T>();

        String json = response.body().string();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        Gson gson = new Gson();
        Class<T> tClass = null;
        Class cl =this.getClass();
        ParameterizedType type = (ParameterizedType)cl.getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        tClass = (Class<T>)types[0];
        for (final JsonElement je:array){

            list.add((T)gson.fromJson(json,tClass));
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                onUi(list);
            }
        });
    }
}
