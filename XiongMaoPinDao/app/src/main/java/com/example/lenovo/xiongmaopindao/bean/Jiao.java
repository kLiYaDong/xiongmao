package com.example.lenovo.xiongmaopindao.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/12/22.
 */
public class Jiao {
    private List<VideoBean> video;

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167308855
         * order : 253
         * vid : c38d42416d604d97bba556438e459a2d
         * t : 《特别节目》 20170825 斧头山“吻熊大盗”--梅奶妈
         * url : http://tv.cntv.cn/video/VSET100167308855/c38d42416d604d97bba556438e459a2d
         * ptime : 2017-08-25 15:19:43
         * img : http://p3.img.cctvpic.com/fmspic/2017/08/25/c38d42416d604d97bba556438e459a2d-129.jpg?p=2&h=120
         * len : 00:04:42
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        @Override
        public String toString() {
            return "VideoBean{" +
                    "vsid='" + vsid + '\'' +
                    ", order='" + order + '\'' +
                    ", vid='" + vid + '\'' +
                    ", t='" + t + '\'' +
                    ", url='" + url + '\'' +
                    ", ptime='" + ptime + '\'' +
                    ", img='" + img + '\'' +
                    ", len='" + len + '\'' +
                    ", em='" + em + '\'' +
                    '}';
        }
    }
}
