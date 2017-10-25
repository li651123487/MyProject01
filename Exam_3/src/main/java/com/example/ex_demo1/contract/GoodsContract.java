package com.example.ex_demo1.contract;

import com.example.ex_demo1.bean.GoodsBean;

import java.util.List;

/**
 * Created by Mr.Li on 2017/10/24.
 * 说明：合同契约类
 */

public class GoodsContract {

    //view显示数据方法
    public interface IGoodView{
        void setData(List<GoodsBean.DataBean> data);
    }

    //后台请求数据方法，GsonObjectCallback已请求到数据返回一个集合，
    // 所以在这传入一个view，以便view.去显示数据
    public interface IGoodModel{
       void getDataByNet(IGoodView view);
    }

    //只提供一个方法即可，
    // 请求数据GsonObjectCallback
    //显示数据view.setData（list）
    public interface IGoodPresenter{
        void showData();
    }
}
