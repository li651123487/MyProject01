package com.example.mvpdemo2.model;

import com.example.mvpdemo2.constract.MusicConstract;
import com.example.mvpdemo2.utils.OKHttp3Utils;

/**
 * Created by Mr.Li on 2017\10\19 0019.
 * 说明：
 */

public class MusicModel implements MusicConstract.IMusicModel{


    @Override
    public void getMusicList(int offset, MusicConstract.IMusicView view) {

        OKHttp3Utils.doGet();
    }
}
