package com.test.mysql.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "inventoryusers")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private String username;
    private String usercellphone;
    private String email;
    private String password;
    private String postion;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addtime;
    private String lastlogin;
    private String lastip;
    private String delflag;
//    private List<Users> usersList;

    public Users(){

    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercellphone() {
        return usercellphone;
    }

    public void setUsercellphone(String usercellphone) {
        this.usercellphone = usercellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public String getDelflag() {
        return delflag;
    }

    public void setDelflag(String lastflag) {
        this.delflag = delflag;
    }

//    public List<Users> getUsersList() {
//        return usersList;
//    }
//
//    public void setUsersList(List<Users> usersList) {
//        this.usersList = usersList;
//    }
}
