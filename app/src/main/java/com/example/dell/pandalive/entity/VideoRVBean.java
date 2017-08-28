package com.example.dell.pandalive.entity;

import java.util.List;

/**
 * Created by 贾成昆 on 2017/8/25.
 */

public class VideoRVBean {

    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class BigImgBean {
        /**
         * id : TITE1503391965561415
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/8/22/1503391960164_396.jpg
         * order : 1
         * pid : 8ff497729f7e4d9881d643f41f90d378
         * stype :
         * title : 《熊猫TOP榜》一起惹的祸，妹妹背黑锅
         * type : 2
         * url : http://live.ipanda.com/2017/08/21/VIDEkIyralrrjjG4oF2fqmiI170821.shtml
         * vid :
         */

        private String id;
        private String image;
        private String order;
        private String pid;
        private String stype;
        private String title;
        private String type;
        private String url;
        private String vid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getStype() {
            return stype;
        }

        public void setStype(String stype) {
            this.stype = stype;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }
    }

    public static class ListBean {
        /**
         * brief : 第二季第十期：滚滚们的幸福生活
         * id : VSET100284428835
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/14/2017081413321088989.jpg
         * order : 1
         * title : 《熊猫TOP榜》
         * type : 2
         * url : http://live.ipanda.com/2017/08/14/VIDE9RBeSMXnQrCQfJ2HOx4N170814.shtml
         * videoLength : 04:03
         */

        private String brief;
        private String id;
        private String image;
        private String order;
        private String title;
        private String type;
        private String url;
        private String videoLength;

        public String getBrief() {
            return brief;
        }

        public void setBrief(String brief) {
            this.brief = brief;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }
    }
}
