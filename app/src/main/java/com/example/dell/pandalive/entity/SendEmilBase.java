package com.example.dell.pandalive.entity;

/**
 * Created by dell on 2017/9/4.
 */

public class SendEmilBase {


    /**
     * timestamp : 2017-09-04 19:22:15
     * usrid :
     * email : a2023502025@126.com
     * errtype : 101
     * msg : 验证码错误
     * addons : ipanda.android
     * seqid :
     * signature :
     */

    private String timestamp;
    private String usrid;
    private String email;
    private String errtype;
    private String msg;
    private String addons;
    private String seqid;
    private String signature;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getErrtype() {
        return errtype;
    }

    public void setErrtype(String errtype) {
        this.errtype = errtype;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }

    public String getSeqid() {
        return seqid;
    }

    public void setSeqid(String seqid) {
        this.seqid = seqid;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
