package com.example.dell.pandalive.entity;

import java.util.List;

/**
 * Created by dell on 2017/8/25.
 */

public class VideoBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/08/24/VIDE4XyAr5CrOuxi1zTlCHrY170824.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/25/2017082509105929117.jpg
         * title : 《超萌滚滚秀》幼儿园里欢乐多
         * videoLength : 02:26
         * id : TITE1503653304461784
         * daytime : 2017-08-24
         * type : 2
         * pid : 8624ba050f7642bf80e961db51ab1d20
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
