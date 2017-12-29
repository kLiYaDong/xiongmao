package com.example.lenovo.xiongmaopindao.bean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/22.
 */
public class JieQi {

    private List<InteractiveBean> interactive;

    public List<InteractiveBean> getInteractive() {
        return interactive;
    }

    public void setInteractive(List<InteractiveBean> interactive) {
        this.interactive = interactive;
    }

    public static class InteractiveBean {
        @Override
        public String toString() {
            return "InteractiveBean{" +
                    "image='" + image + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", order='" + order + '\'' +
                    '}';
        }

        /**
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/6/5/1496626374961_922.jpg
         * title : 二十四节气——芒种
         * url : http://webapp.cctv.com/h5/travel/U80531QU7SY7.html
         * order : 1
         */

        private String image;
        private String title;
        private String url;
        private String order;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
