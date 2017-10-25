package com.erin.week02_demo.constract;

import com.erin.week02_demo.bean.MusicBean;
import com.erin.week02_demo.model.MusicModel;

import java.util.List;

import okhttp3.Callback;

/**
 * Created by mamiaomiao on 2017/10/16.
 * constract：构建 合同
 */

public class MusicConstract {

    //view显示数据
    public interface IMusicView {
        void setData(List<MusicBean.SongListBean> list);
    }

    //model获取数据
    public interface IMusicModel {
        void getData(int offset, MusicModel.CallBack re);//offset默认显示条目数，后面是接口回调网络请求数据
    }

    //
    public interface IMusicPresenter {
        void showOnUi(int offset);
    }

}
