package com.erin.week02_demo.presenter;

import com.erin.week02_demo.bean.MusicBean;
import com.erin.week02_demo.constract.MusicConstract;
import com.erin.week02_demo.model.MusicModel;

import java.util.List;

import static android.os.Build.VERSION_CODES.M;


/**
 * Created by mamiaomiao on 2017/10/16.
 */

public class MusicPresenter implements MusicConstract.IMusicPresenter {

    private MusicModel model;
    private MusicConstract.IMusicView view;

    public MusicPresenter(MusicConstract.IMusicView view) {

        this.model = new MusicModel();
        this.view = view;
    }

    @Override
    public void showOnUi(int offset) {
        model.getData(offset, new MusicModel.CallBack() {
            @Override
            public void showData(List<MusicBean.SongListBean> list) {
                view.setData(list);
            }
        });
    }

    //    public MusicPresenter(MusicConstract.IMusicView view){
//        model=new MusicModel();
//        this.view=view;
//    }
//    @Override
//    public void getData(int offset) {
//
//        model.getMusicList(offset,view);
//    }
}
