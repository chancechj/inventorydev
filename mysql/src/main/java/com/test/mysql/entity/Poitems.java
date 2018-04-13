package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorypoitems")
public class Poitems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long poid;
    private long poitem;
    private String goodid;
    private String ponum;
    private String pounit;
    private long storageid;
    private String goodpurchase;

    public Poitems(){

    }

    public long getPoid() {
        return poid;
    }

    public void setPoid(long poid) {
        this.poid = poid;
    }

    public long getPoitem() {
        return poitem;
    }

    public void setPoitem(long poitem) {
        this.poitem = poitem;
    }

    public String getGoodid() {
        return goodid;
    }

    public void setGoodid(String goodid) {
        this.goodid = goodid;
    }

    public String getPonum() {
        return ponum;
    }

    public void setPonum(String ponum) {
        this.ponum = ponum;
    }

    public String getPounit() {
        return pounit;
    }

    public void setPounit(String pounit) {
        this.pounit = pounit;
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
