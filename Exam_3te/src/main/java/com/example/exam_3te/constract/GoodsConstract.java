package com.example.exam_3te.constract;

import com.example.exam_3te.bean.GoodsBean;

import java.util.List;

/**
 * Created by Mr.Li on 2017\10\25 0025.
 * 说明：
 */

public class GoodsConstract {

    public interface IGoodsView{
        void setData(List<GoodsBean.DataBean> list);
    }

    public interface IGoodsModel{
        void setData(IGoodsView view);
    }

    public interface GoodsPresenter{
        void showData();
    }
}
