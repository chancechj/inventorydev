package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorysoitems")
public class Soitems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long soid;
    private long soitem;
    private String goodid;
    private String sonum;
    private String sounit;
    private long storageid;
    private String goodpurchase;

    public Soitems(){

    }

    public long getSoid() {
        return soid;
    }

    public void setSoid(long soid) {
        this.soid = soid;
    }

    public long getSoitem() {
        return soitem;
    }

    public void setSoitem(long soitem) {
        this.soitem = soitem;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid;
    }

    public String getSonum() {
        return sonum;
    }

    public void setSonum(String sonum) {
        this.sonum = sonum;
    }

    public String getSounit() {
        return sounit;
    }

    public void setSounit(String sounit) {
        this.sounit = sounit;
    }

    public long getStorageid() {
        return storageid;
    }

    public void setStorageid(long storageid) {
        this.storageid = storageid;
    }

    public String getGoodpurchase() {
        return goodpurchase;
    }

    public void setGoodpurchase(String goodpurchase) {
        this.goodpurchase = goodpurchase;
    }
}
