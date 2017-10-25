package com.example.ex_demo1.model;

import android.os.Handler;

import com.example.ex_demo1.bean.GoodsBean;
import com.example.ex_demo1.contract.GoodsContract;
import com.example.ex_demo1.utils.GsonObjectCallback;
import com.example.ex_demo1.utils.OkHttp3Utils;

import java.io.IOException;

import okhttp3.Call;

/**
 * Created by Mr.Li on 2017/10/21.
 */

public class GoodsModel implements GoodsContract.IGoodModel {

    private String url = "http://120.27.23.105/product/getProducts?pscid=1";
    private Handler handler = new Handler();


    @Override
    public void getDataByNet(final GoodsContract.IGoodView view) {
//        OkHttp3Utils.doGet(url, new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String string = response.body().string();
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        GoodsBean com.example.exam_3te.bean = GoodsBean.objectFromData(string);
//                        view.setData(com.example.exam_3te.bean.data);
//                    }
//                });
//            }
//        });

        OkHttp3Utils.doGet(url, new GsonObjectCallback<GoodsBean>() {
            @Override
            public void onUi(GoodsBean goodsBean) {

                view.setData(goodsBean.data);
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });

    }
}
