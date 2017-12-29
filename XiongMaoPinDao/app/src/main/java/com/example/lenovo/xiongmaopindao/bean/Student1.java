package com.example.lenovo.xiongmaopindao.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/19.
 */
public class Student1 {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        @Override
        public String toString() {
            return "ListBean{" +
                    "url='" + url + '\'' +
                    ", image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    ", videoLength='" + videoLength + '\'' +
                    ", id='" + id + '\'' +
                    ", daytime='" + daytime + '\'' +
                    ", type='" + type + '\'' +
                    ", pid='" + pid + '\'' +
                    ", vid='" + vid + '\'' +
                    ", order='" + order + '\'' +
                    '}';
        }

        /**
         * url : http://live.ipanda.com/2017/12/18/VIDEksPs6EfW9ZQAvePHrAto171218.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/12/18/2017121817495655203.jpg
         * title : 《熊猫TOP榜》2017届小团子向你卖萌
         * videoLength : 00:03:23
         * id : TITE1513592365734958
         * daytime : 2017-12-18
         * type : 2
         * pid : 6116fbf58ac4484dbbef9d9925c864f1
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
