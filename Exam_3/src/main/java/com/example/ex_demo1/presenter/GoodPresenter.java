package com.example.ex_demo1.presenter;

import com.example.ex_demo1.contract.GoodsContract;
import com.example.ex_demo1.model.GoodsModel;

/**
 * Created by Mr.Li on 2017/10/24.
 */

public class GoodPresenter implements GoodsContract.IGoodPresenter {

    private GoodsContract.IGoodView view;
    private GoodsModel model;


    public GoodPresenter(GoodsContract.IGoodView view) {
        this.view = view;
        model = new GoodsModel();
    }

    @Override
    public void showData() {
        model.getDataByNet(view);
    }
}
