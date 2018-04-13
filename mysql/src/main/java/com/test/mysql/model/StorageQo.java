package com.test.mysql.model;

public class StorageQo extends PageQo {
    private long storageid;
    private long goodid;
    private long goodnum;

    public StorageQo(){

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
