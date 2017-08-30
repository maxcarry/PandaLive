package com.example.dell.pandalive.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LiveSplendidBean {


    /**
     * video : [{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/28/f203627819e54419a686f46cc37d08db-9.jpg?p=2&h=120","len":"00:00:19","order":"4785","ptime":"2017-08-28 12:25:28","t":"《精彩一刻》 20170828 乔伊：我就走慢了一步","url":"http://tv.cntv.cn/video/VSET100167216881/f203627819e54419a686f46cc37d08db","vid":"f203627819e54419a686f46cc37d08db","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/28/2369690e091c412b8231ccbd2810fed3-33.jpg?p=2&h=120","len":"00:00:45","order":"4783","ptime":"2017-08-28 12:24:28","t":"《精彩一刻》 20170828 浦浦和神器的虐恋大戏","url":"http://tv.cntv.cn/video/VSET100167216881/2369690e091c412b8231ccbd2810fed3","vid":"2369690e091c412b8231ccbd2810fed3","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/ef11dd80f18a48e6bbc20243c294fb62-33.jpg?p=2&h=120","len":"00:00:45","order":"4784","ptime":"2017-08-28 12:23:30","t":"《精彩一刻》 20170828 rua出一个熊猫面团~","url":"http://tv.cntv.cn/video/VSET100167216881/ef11dd80f18a48e6bbc20243c294fb62","vid":"ef11dd80f18a48e6bbc20243c294fb62","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/28/3d5dce6f41a44de0ad7ae7f1ad44b2db-9.jpg?p=2&h=120","len":"00:00:19","order":"4782","ptime":"2017-08-28 12:22:39","t":"《精彩一刻》 20170828 泡澡也要保持优雅身姿~","url":"http://tv.cntv.cn/video/VSET100167216881/3d5dce6f41a44de0ad7ae7f1ad44b2db","vid":"3d5dce6f41a44de0ad7ae7f1ad44b2db","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/1665116d91894ef380cc229b2487e92e-21.jpg?p=2&h=120","len":"00:00:33","order":"4781","ptime":"2017-08-28 09:28:44","t":"《精彩一刻》 20170828 \u201c成实\u201d不爱回家，叛逆又任性","url":"http://tv.cntv.cn/video/VSET100167216881/1665116d91894ef380cc229b2487e92e","vid":"1665116d91894ef380cc229b2487e92e","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/28/1ced7e68bcb641378b5f3f123966cc13-21.jpg?p=2&h=120","len":"00:00:21","order":"4780","ptime":"2017-08-28 09:27:07","t":"《精彩一刻》 20170828 我叫滚滚，我爱翻滚","url":"http://tv.cntv.cn/video/VSET100167216881/1ced7e68bcb641378b5f3f123966cc13","vid":"1ced7e68bcb641378b5f3f123966cc13","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/28/002a5db105c8469d9cf12f35a0b3aee1-22.jpg?p=2&h=120","len":"00:00:37","order":"4778","ptime":"2017-08-28 09:25:46","t":"《精彩一刻》 20170828 \u201c成实\u201d绝活之倒挂金钩","url":"http://tv.cntv.cn/video/VSET100167216881/002a5db105c8469d9cf12f35a0b3aee1","vid":"002a5db105c8469d9cf12f35a0b3aee1","vsid":"VSET100167216881"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""},"count":"4781"}
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
         * 0 : {"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""}
         * count : 4781
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
             * bj :
             * cd :
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * js :
             * name : 熊猫频道-精彩一刻
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj : 2013-05-01
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * vsid : VSET100167216881
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p1.img.cctvpic.com/fmspic/2017/08/28/f203627819e54419a686f46cc37d08db-9.jpg?p=2&h=120
         * len : 00:00:19
         * order : 4785
         * ptime : 2017-08-28 12:25:28
         * t : 《精彩一刻》 20170828 乔伊：我就走慢了一步
         * url : http://tv.cntv.cn/video/VSET100167216881/f203627819e54419a686f46cc37d08db
         * vid : f203627819e54419a686f46cc37d08db
         * vsid : VSET100167216881
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
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

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
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

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
