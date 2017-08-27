package com.example.dell.pandalive.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */

public class Livabean {

    /**
     * videoset : {"0":{"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""},"count":"4763"}
     * video : [{"vsid":"VSET100167216881","order":"4767","vid":"72336f53016648cb8185ca2310dc6f96","t":"《精彩一刻》 20170826 给大家敬个礼吧","url":"http://tv.cntv.cn/video/VSET100167216881/72336f53016648cb8185ca2310dc6f96","ptime":"2017-08-26 10:58:44","img":"http://p5.img.cctvpic.com/fmspic/2017/08/26/72336f53016648cb8185ca2310dc6f96-32.jpg?p=2&h=120","len":"00:00:44","em":"CM01"},{"vsid":"VSET100167216881","order":"4766","vid":"e3ef2c820cdf46de916716a407e35f86","t":"《精彩一刻》 20170826 今天的笋笋有点啃不动","url":"http://tv.cntv.cn/video/VSET100167216881/e3ef2c820cdf46de916716a407e35f86","ptime":"2017-08-26 10:57:02","img":"http://p2.img.cctvpic.com/fmspic/2017/08/26/e3ef2c820cdf46de916716a407e35f86-33.jpg?p=2&h=120","len":"00:00:45","em":"CM01"},{"vsid":"VSET100167216881","order":"4763","vid":"f05d5aee846d43d29fad37ba8df97071","t":"《精彩一刻》 20170826 我在卖萌，你看不到吗！","url":"http://tv.cntv.cn/video/VSET100167216881/f05d5aee846d43d29fad37ba8df97071","ptime":"2017-08-26 10:55:13","img":"http://p4.img.cctvpic.com/fmspic/2017/08/26/f05d5aee846d43d29fad37ba8df97071-9.jpg?p=2&h=120","len":"00:00:19","em":"CM01"},{"vsid":"VSET100167216881","order":"4765","vid":"d35b4c5f5b4c4d679d25b2e6f3e548a1","t":"《精彩一刻》 20170826 我有一颗勇敢的心","url":"http://tv.cntv.cn/video/VSET100167216881/d35b4c5f5b4c4d679d25b2e6f3e548a1","ptime":"2017-08-26 10:53:21","img":"http://p1.img.cctvpic.com/fmspic/2017/08/26/d35b4c5f5b4c4d679d25b2e6f3e548a1-22.jpg?p=2&h=120","len":"00:00:24","em":"CM01"},{"vsid":"VSET100167216881","order":"4764","vid":"dc1c3c7adcc34ff89994c6f4ba9a1688","t":"《精彩一刻》 20170826 迈开这步不容易","url":"http://tv.cntv.cn/video/VSET100167216881/dc1c3c7adcc34ff89994c6f4ba9a1688","ptime":"2017-08-26 10:51:50","img":"http://p4.img.cctvpic.com/fmspic/2017/08/26/dc1c3c7adcc34ff89994c6f4ba9a1688-24.jpg?p=2&h=120","len":"00:00:27","em":"CM01"},{"vsid":"VSET100167216881","order":"4762","vid":"7bd5dcdfd8244218a09ba85100bf782b","t":"《精彩一刻》 20170826 柔软的成胖子","url":"http://tv.cntv.cn/video/VSET100167216881/7bd5dcdfd8244218a09ba85100bf782b","ptime":"2017-08-26 10:50:15","img":"http://p4.img.cctvpic.com/fmspic/2017/08/26/7bd5dcdfd8244218a09ba85100bf782b-23.jpg?p=2&h=120","len":"00:00:26","em":"CM01"},{"vsid":"VSET100167216881","order":"4761","vid":"66c59256bcca40b9a1f90ab42306e5bf","t":"《精彩一刻》 20170826 奶爸已放弃抱你回家","url":"http://tv.cntv.cn/video/VSET100167216881/66c59256bcca40b9a1f90ab42306e5bf","ptime":"2017-08-26 10:47:37","img":"http://p1.img.cctvpic.com/fmspic/2017/08/26/66c59256bcca40b9a1f90ab42306e5bf-21.jpg?p=2&h=120","len":"00:00:32","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100167216881","relvsid":"","name":"熊猫频道-精彩一刻","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100167216881","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"2013-05-01","sbpd":"其他","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","playdesc":"","zcr":"","fcl":""}
         * count : 4763
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100167216881
             * relvsid :
             * name : 熊猫频道-精彩一刻
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj : 2013-05-01
             * sbpd : 其他
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100167216881
         * order : 4767
         * vid : 72336f53016648cb8185ca2310dc6f96
         * t : 《精彩一刻》 20170826 给大家敬个礼吧
         * url : http://tv.cntv.cn/video/VSET100167216881/72336f53016648cb8185ca2310dc6f96
         * ptime : 2017-08-26 10:58:44
         * img : http://p5.img.cctvpic.com/fmspic/2017/08/26/72336f53016648cb8185ca2310dc6f96-32.jpg?p=2&h=120
         * len : 00:00:44
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
    }
}
