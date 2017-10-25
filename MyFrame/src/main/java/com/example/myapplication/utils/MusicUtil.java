package com.example.myapplication.utils;

import android.os.Environment;

import com.example.myapplication.model.MusicInfo;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Mr.Li on 2017/9/13.
 */
//获取音乐列表
public class MusicUtil {

    public static ArrayList<MusicInfo> getMusicList(){
        ArrayList<MusicInfo> list = new ArrayList<MusicInfo>();
        File file = Environment.getExternalStorageDirectory(); // 根目录
        // 判断是否有MP3文件
        if (file.listFiles(new MyFileFilter()).length > 0) {
            for (File fi : file.listFiles(new MusicFilter())) {
                MusicInfo info = new MusicInfo();
                info.setMusicName(fi.getName());
                info.setAbsolutePath(fi.getAbsolutePath());
                list.add(info);
            }
        }
        return list;
    }
}
