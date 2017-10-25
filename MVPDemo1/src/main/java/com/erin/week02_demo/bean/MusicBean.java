package com.erin.week02_demo.bean;

import java.util.List;

/**
 * Created by mamiaomiao on 2017/10/16.
 */

public class MusicBean {

    private List<SongListBean> song_list;

    public List<SongListBean> getSong_list() {

        return song_list;
    }

    public void setSong_list(List<SongListBean> song_list) {

        this.song_list = song_list;
    }

    public static class SongListBean {


        private String pic_small;
        private String title;
        private String album_title;

        public String getPic_small() {

            return pic_small;
        }

        public void setPic_small(String pic_small) {

            this.pic_small = pic_small;
        }

        public String getTitle() {

            return title;
        }

        public void setTitle(String title) {

            this.title = title;
        }

        public String getAlbum_title() {

            return album_title;
        }

        public void setAlbum_title(String album_title) {

            this.album_title = album_title;
        }
    }
}
