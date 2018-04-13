package com.test.mysql.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GoodsQo extends PageQo {
    private long goodid;
    private String goodname;
    private String goodtype;
    private String goodunit;
    private String goodpurchase;
    private String goodtrade;
    private String goodretail;
    private String createman;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    private long lasteditman;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private long lasteditdete;

    public GoodsQo() {
    }

    public long getGoodid() {
        return goodid;
    }

    public void setGoodid(long goodid) {
        this.goodid = goodid;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getGoodtype() {
        return goodtype;
    }

    public void setGoodtype(String goodtype) {
        this.goodtype = goodtype;
    }

    public String getGoodunit() {
        return goodunit;
    }

    public void setGoodunit(String goodunit) {
        this.goodunit = goodunit;
    }

    public String getGoodpurchase() {
        return goodpurchase;
    }

    public void setGoodpurchase(String goodpurchase) {
        this.goodpurchase = goodpurchase;
    }

    public String getGoodtrade() {
        return goodtrade;
    }

    public void setGoodtrade(String goodtrade) {
        this.goodtrade = goodtrade;
    }

    public String getGoodretail() {
        return goodretail;
    }

    public void setGoodretail(String goodretail) {
        this.goodretail = goodretail;
    }

    public String getcreateman() {
        return createman;
    }

    public void setcreateman(String createman) {
        this.createman = createman;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public long getLasteditman() {
        return lasteditman;
    }

    public void setLasteditman(long lasteditman) {
        this.lasteditman = lasteditman;
    }

    public long getLasteditdete() {
        return lasteditdete;
    }

    public void setLasteditdete(long lasteditdete) {
        this.lasteditdete = lasteditdete;
    }
}
