package com.example.dell.pandalive.ui.livepanda.perform;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */

public class LivePerformBean {

    /**
     * videoset : {"0":{"vsid":"VSET100272959126","relvsid":"","name":"77滚滚秀","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","enname":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","playdesc":"","zcr":"","fcl":""},"count":"70"}
     * video : [{"vsid":"VSET100272959126","order":"67","vid":"00362cdfea104d7298feacfbe8b40549","t":"《77滚滚秀》 20170409 第六十七期：当时我就震惊了","url":"http://tv.cntv.cn/video/VSET100272959126/00362cdfea104d7298feacfbe8b40549","ptime":"2017-04-09 17:30:45","img":"http://p2.img.cctvpic.com/fmspic/2017/04/09/00362cdfea104d7298feacfbe8b40549-87.jpg","len":"00:02:34","em":"CM01"},{"vsid":"VSET100272959126","order":"66","vid":"cea3a33cd54a45988d0512d65b9b2aae","t":"《77滚滚秀》 20170331 第六十六期：寻奶大作战","url":"http://tv.cntv.cn/video/VSET100272959126/cea3a33cd54a45988d0512d65b9b2aae","ptime":"2017-03-31 18:33:24","img":"http://p2.img.cctvpic.com/fmspic/2017/03/31/cea3a33cd54a45988d0512d65b9b2aae-91.jpg","len":"00:02:41","em":"CM01"},{"vsid":"VSET100272959126","order":"65","vid":"2385afcf3a2b4546a8a205ff81f01d47","t":"《77滚滚秀》 20170325 第六十五期：爱挤油的团子","url":"http://tv.cntv.cn/video/VSET100272959126/2385afcf3a2b4546a8a205ff81f01d47","ptime":"2017-03-25 15:39:07","img":"http://p4.img.cctvpic.com/fmspic/2017/03/25/2385afcf3a2b4546a8a205ff81f01d47-87.jpg","len":"00:02:34","em":"CM01"},{"vsid":"VSET100272959126","order":"64","vid":"3c6b9ac4badc4b06a0ec5746fcd15ec8","t":"《77滚滚秀》 20170318 第六十四期：至尊唱片MV","url":"http://tv.cntv.cn/video/VSET100272959126/3c6b9ac4badc4b06a0ec5746fcd15ec8","ptime":"2017-03-18 19:42:01","img":"http://p4.img.cctvpic.com/fmspic/2017/03/18/3c6b9ac4badc4b06a0ec5746fcd15ec8-129.jpg","len":"00:04:05","em":"CM01"},{"vsid":"VSET100272959126","order":"63","vid":"7588082c0abe44e99d006bae0ac926c7","t":"《77滚滚秀》 20170313 第六十三期：聪明滚滚一大堆！","url":"http://tv.cntv.cn/video/VSET100272959126/7588082c0abe44e99d006bae0ac926c7","ptime":"2017-03-13 13:13:37","img":"http://p1.img.cctvpic.com/fmspic/2017/03/13/7588082c0abe44e99d006bae0ac926c7-99.jpg","len":"00:02:57","em":"CM01"},{"vsid":"VSET100272959126","order":"62","vid":"072081c57c7a412caf97380bd591ad91","t":"《77滚滚秀》 20170224 第六十二期：这团子交给你来守护吧！","url":"http://tv.cntv.cn/video/VSET100272959126/072081c57c7a412caf97380bd591ad91","ptime":"2017-02-24 19:43:57","img":"http://p1.img.cctvpic.com/fmspic/2017/02/24/072081c57c7a412caf97380bd591ad91-92.jpg","len":"00:02:44","em":"CM01"},{"vsid":"VSET100272959126","order":"61","vid":"3bd6524358714403bf52c3331fc68214","t":"《77滚滚秀》 20170217 第六十一期：和滚滚一起趴的周末!","url":"http://tv.cntv.cn/video/VSET100272959126/3bd6524358714403bf52c3331fc68214","ptime":"2017-02-17 17:50:13","img":"http://p2.img.cctvpic.com/fmspic/2017/02/17/3bd6524358714403bf52c3331fc68214-87.jpg","len":"00:02:34","em":"CM01"}]
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
         * 0 : {"vsid":"VSET100272959126","relvsid":"","name":"77滚滚秀","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg","enname":"","url":"http://tv.cntv.cn/videoset/VSET100272959126","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"","desc":"《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神\u201c技能\u201d，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。","playdesc":"","zcr":"","fcl":""}
         * count : 70
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
             * vsid : VSET100272959126
             * relvsid :
             * name : 77滚滚秀
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETBr7Ufabb0BvOFDWAzU1Z160704.jpg
             * enname :
             * url : http://tv.cntv.cn/videoset/VSET100272959126
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj :
             * sbpd :
             * desc : 《77滚滚秀》是一档集合所有滚滚精彩瞬间的娱乐、搞笑类节目，在这里你可以看到滚滚们搞笑、尴尬、萌萌哒，以及前所未见的所有神“技能”，每周五准时更新，还有更多互动和奖品等着你，快来加入我们吧。
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
         * vsid : VSET100272959126
         * order : 67
         * vid : 00362cdfea104d7298feacfbe8b40549
         * t : 《77滚滚秀》 20170409 第六十七期：当时我就震惊了
         * url : http://tv.cntv.cn/video/VSET100272959126/00362cdfea104d7298feacfbe8b40549
         * ptime : 2017-04-09 17:30:45
         * img : http://p2.img.cctvpic.com/fmspic/2017/04/09/00362cdfea104d7298feacfbe8b40549-87.jpg
         * len : 00:02:34
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
