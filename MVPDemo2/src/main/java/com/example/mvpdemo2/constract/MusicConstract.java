package com.example.mvpdemo2.constract;

import com.example.mvpdemo2.bean.MusicBean;

import java.util.List;

/**
 * Created by Mr.Li on 2017\10\19 0019.
 * 说明：
 */

public interface MusicConstract {

    interface IMusicView {
        void setData(List<MusicBean.SongListBean> list);
    }

    interface IMusicModel {
        void getMusicList(int offset,IMusicView view);
    }

    abstract class IMusicPresenter {
        public abstract void getData(int offset);
    }

}
