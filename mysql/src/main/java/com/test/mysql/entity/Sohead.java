package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorysohead")
public class Sohead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long soid;
    private String socreater;
    private long customerid;
    private String soarea;
    private String sotype;
    private String sodelflag;
    private String sototal;
    private String sddate;

    public Sohead(){

    }

    public long getSoid() {
        return soid;
    }

    public void setSoid(long soid) {
        this.soid = soid;
    }

    public String getSocreater() {
        return socreater;
    }

    public void setSocreater(String socreater) {
        this.socreater = socreater;
    }

    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getSoarea() {
        return soarea;
    }

    public void setSoarea(String soarea) {
        this.soarea = soarea;
    }

    public String getSotype() {
        return sotype;
    }

    public void setSotype(String sotype) {
        this.sotype = sotype;
    }

    public String getSodelflag() {
        return sodelflag;
    }

    public void setSodelflag(String sodelflag) {
        this.sodelflag = sodelflag;
    }

    public String getSototal() {
        return sototal;
    }

    public void setSototal(String sototal) {
        this.sototal = sototal;
    }

    public String getSddate() {
        return sddate;
    }

    public void setSddate(String sddate) {
        this.sddate = sddate;
    }
}
