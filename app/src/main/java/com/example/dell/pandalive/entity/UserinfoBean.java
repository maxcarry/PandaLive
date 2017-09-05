package com.example.dell.pandalive.entity;

/**
 * Created by dell on 2017/9/3.
 */

public class UserinfoBean {


    /**
     * code : 0
     * content : {"nickname":"央视网友8l6u2l3a","userface":"http://userface.img.cctvpic.com/80x80/181/25/55615510.jpg"}
     */

    private int code;
    private ContentBean content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * nickname : 央视网友8l6u2l3a
         * userface : http://userface.img.cctvpic.com/80x80/181/25/55615510.jpg
         */

        private String nickname;
        private String userface;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUserface() {
            return userface;
        }

        public void setUserface(String userface) {
            this.userface = userface;
        }
    }
}
