package com.example.dell.pandalive.entity;

import java.util.List;

/**
 * Created by dell on 2017/8/25.
 */

public class TvBean {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/08/24/VIDEatKXynJaRUsccvTdF2Mk170824.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/24/2017082417244352384.jpg
         * title : 熊牌脚垫 至尊享受
         * videoLength : 00:19
         * id : TITE1503641395129209
         * daytime : 2017-08-25
         * type : 2
         * pid : bded4c3430c84c7b814093c1c6b61a82
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
