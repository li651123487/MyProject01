package com.example.myapplication.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Mr.Li on 2017/9/13.
 */
//过滤所有以输入的内容为结尾的文件
public class MyFileFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String filename) {
        return filename.endsWith("输入你想查找的以什么结尾的文件");//.MP3
    }

}
