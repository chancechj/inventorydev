package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorystorage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storageid;
    private long goodid;
    private long goodnum;

    public Storage(){

    }

    public long getStorageid() {
        return storageid;
    }

    public void setStorageid(long storageid) {
        this.storageid = storageid;
    }

    public long getGoodid() {
        return goodid;
    }

    public void setGoodid(long goodid) {
        this.goodid = goodid;
    }

    public long getGoodnum() {
        return goodnum;
    }

    public void setGoodnum(long goodnum) {
        this.goodnum = goodnum;
    }
}
