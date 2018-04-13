package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorypohead")
public class Pohead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long poid;
    private String pocreater;
    private String suppliersid;
    private String poarea;
    private String potype;
    private String podelfalg;
    private String podefaultdiscount;
    private String pototal;
    private String podate;

    public Pohead(){

    }

    public long getPoid() {
        return poid;
    }

    public void setPoid(long poid) {
        this.poid = poid;
    }

    public String getPocreater() {
        return pocreater;
    }

    public void setPocreater(String pocreater) {
        this.pocreater = pocreater;
    }

    public String getSuppliersid() {
        return suppliersid;
    }

    public void setSuppliersid(String suppliersid) {
        this.suppliersid = suppliersid;
    }

    public String getPoarea() {
        return poarea;
    }

    public void setPoarea(String poarea) {
        this.poarea = poarea;
    }

    public String getPotype() {
        return potype;
    }

    public void setPotype(String potype) {
        this.potype = potype;
    }

    public String getPodelfalg() {
        return podelfalg;
    }

    public void setPodelfalg(String podelfalg) {
        this.podelfalg = podelfalg;
    }

    public String getPodefaultdiscount() {
        return podefaultdiscount;
    }

    public void setPodefaultdiscount(String podefaultdiscount) {
        this.podefaultdiscount = podefaultdiscount;
    }

    public String getPototal() {
        return pototal;
    }

    public void setPototal(String pototal) {
        this.pototal = pototal;
    }

    public String getPodate() {
        return podate;
    }

    public void setPodate(String podate) {
        this.podate = podate;
    }
}
