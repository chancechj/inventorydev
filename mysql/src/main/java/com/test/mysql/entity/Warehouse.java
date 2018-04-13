package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorywarehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storageid;
    private String storagename;
    private String storagearea;

    public Warehouse ( ) {
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
