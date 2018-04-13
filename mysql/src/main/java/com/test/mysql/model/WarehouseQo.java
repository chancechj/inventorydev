package com.test.mysql.model;

public class WarehouseQo extends PageQo{
    private long storageid;
    private String storagename;
    private String storagearea;

    public WarehouseQo(){

    }
    public long getStorageid() {
        return storageid;
    }

    public void setStorageid(long storageid) {
        this.storageid = storageid;
    }

    public String getStoragename() {
        return storagename;
    }

    public void setStoragename(String storagename) {
        this.storagename = storagename;
    }

    public String getStoragearea() {
        return storagearea;
    }

    public void setStoragearea(String storagearea) {
        this.storagearea = storagearea;
    }
}

