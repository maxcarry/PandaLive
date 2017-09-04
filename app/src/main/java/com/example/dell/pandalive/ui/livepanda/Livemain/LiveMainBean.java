package com.example.dell.pandalive.ui.livepanda.Livemain;

import java.util.List;

/**
 * Created by Administrator on 2017/9/1.
 */

public class LiveMainBean {


    /**
     * bookmark : {"multiple":[{"order":"1","title":"多视角直播","url":"http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json"}],"watchTalk":[{"order":"1","title":"边看边聊","url":"zhiboye_chat"}]}
     * live : [{"brief":"翻身、吃饭、睡觉、喝奶、打闹、攀爬\u2026\u2026这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。","id":"ipanda","image":"http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg","isshow":"true","title":"成都基地高清精切线路","url":"http://live.ipanda.com/stream/"}]
     */

    private BookmarkBean bookmark;
    private List<LiveBean> live;

    public BookmarkBean getBookmark() {
        return bookmark;
    }

    public void setBookmark(BookmarkBean bookmark) {
        this.bookmark = bookmark;
    }

    public List<LiveBean> getLive() {
        return live;
    }

    public void setLive(List<LiveBean> live) {
        this.live = live;
    }

    public static class BookmarkBean {
        private List<MultipleBean> multiple;
        private List<WatchTalkBean> watchTalk;

        public List<MultipleBean> getMultiple() {
            return multiple;
        }

        public void setMultiple(List<MultipleBean> multiple) {
            this.multiple = multiple;
        }

        public List<WatchTalkBean> getWatchTalk() {
            return watchTalk;
        }

        public void setWatchTalk(List<WatchTalkBean> watchTalk) {
            this.watchTalk = watchTalk;
        }

        public static class MultipleBean {
            /**
             * order : 1
             * title : 多视角直播
             * url : http://www.ipanda.com/kehuduan/PAGE14501769230331752/PAGE14501787896813312/index.json
             */

            private String order;
            private String title;
            private String url;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class WatchTalkBean {
            /**
             * order : 1
             * title : 边看边聊
             * url : zhiboye_chat
             */

            private String order;
            private String title;
            private String url;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class LiveBean {
        /**
         * brief : 翻身、吃饭、睡觉、喝奶、打闹、攀爬……这里是成都大熊猫繁育研究基地，24小时高清直播大熊猫生活实况的地方。成年园、幼年园、幼儿园、母子园、一号别墅，11路直播信号28个摄像头，让你零距离了解国宝们的日常起居。
         * id : ipanda
         * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2016/1/5/1451989464985_497.jpg
         * isshow : true
         * title : 成都基地高清精切线路
         * url : http://live.ipanda.com/stream/
         */

        private String brief;
        private String id;
        private String image;
        private String isshow;
        private String title;
        private String url;

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

        public String getIsshow() {
            return isshow;
        }

        public void setIsshow(String isshow) {
            this.isshow = isshow;
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
    }
}
