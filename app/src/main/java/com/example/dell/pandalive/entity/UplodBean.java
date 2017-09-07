package com.example.dell.pandalive.entity;

/**
 * Created by dell on 2017/9/5.
 */

public class UplodBean {


    /**
     * code : -103
     * error : 参数错误：您提供的用户id为空，请查阅文档或咨询接口提供方！
     */

    private int code;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
