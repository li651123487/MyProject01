package com.erin.week02_demo.model;

import com.erin.week02_demo.constract.MusicConstract;
import com.erin.week02_demo.bean.MusicBean;
import com.erin.week02_demo.utils.GsonObjectCallback;
import com.erin.week02_demo.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;


/**
 * Created by mamiaomiao on 2017/10/16.
 */

public class MusicModel implements MusicConstract.IMusicModel{
    @Override
    public void getData(int offset, final CallBack re) {
        OkHttp3Utils.doGet("http://tingapi.ting.baidu.com/v1/restserver/ting?" +
                                                "method=baidu.ting.billboard.billList&type=1&size=10&offset="
                                                + offset, new GsonObjectCallback<MusicBean>() {//返回musicBean.getSong_list()
                                            @Override
                                            public void onUi(MusicBean musicBean) {

                                                re.showData(musicBean.getSong_list());
                                            }

                                            @Override
                                            public void onFailed(Call call, IOException e) {

                                            }
                                        });
    }


    //接口回调请求数据
    public interface CallBack{
         void showData(List<MusicBean.SongListBean> list);

        }
    }

