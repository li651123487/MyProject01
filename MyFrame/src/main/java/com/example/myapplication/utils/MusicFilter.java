package com.example.myapplication.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Mr.Li on 2017/9/13.
 */
//过滤所有以.mp3结尾的文件
public class MusicFilter implements FilenameFilter {
	@Override
	public boolean accept(File dir, String filename) {
		return filename.endsWith(".mp3");
	}

}
