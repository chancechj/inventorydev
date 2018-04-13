package com.test.mysql.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventorycustomers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerid;
    private String customercellphone;
    private String customername;
    private String customeraddress;
    private String customerarea;
    private String customerzip;
    private String customerpayment;
    private String customerpaymentpayid;

    public Customers(){

    }
    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    public String getCustomercellphone() {
        return customercellphone;
    }

    public void setCustomercellphone(String customercellphone) {
        this.customercellphone = customercellphone;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    public String getCustomerarea() {
        return customerarea;
    }

    public void setCustomerarea(String customerarea) {
        this.customerarea = customerarea;
    }

    public String getCustomerzip() {
        return customerzip;
    }

    public void setCustomerzip(String customerzip) {
        this.customerzip = customerzip;
    }

    public String getCustomerpayment() {
        return customerpayment;
    }

    public void setCustomerpayment(String customerpayment) {
        this.customerpayment = customerpayment;
    }

    public String getCustomerpaymentpayid() {
        return customerpaymentpayid;
    }

    public void setCustomerpaymentpayid(String customerpaymentpayid) {
        this.customerpaymentpayid = customerpaymentpayid;
    }
}
