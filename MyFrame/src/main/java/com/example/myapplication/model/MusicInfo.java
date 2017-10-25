package com.example.myapplication.model;

import java.io.Serializable;
/**
 * Created by Mr.Li on 2017/9/13.
 */
public class MusicInfo implements Serializable {

	private static final long serialVersionUID = 1555597629891698346L;
	private String musicName; // 音乐名称
	private String absolutePath; // 绝对路径

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	@Override
	public String toString() {
		return "MusicInfo [musicName=" + musicName + ", absolutePath="
				+ absolutePath + "]";
	}

}
