package com.test.mysql.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "inventorygoods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String lasteditman;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lasteditdete;

    public Goods(){
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

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getLasteditman() {
        return lasteditman;
    }

    public void setLasteditman(String lasteditman) {
        this.lasteditman = lasteditman;
    }

    public Date getLasteditdete() {
        return lasteditdete;
    }

    public void setLasteditdete(Date lasteditdete) {
        this.lasteditdete = lasteditdete;
    }
}
