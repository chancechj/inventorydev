package com.test.web.service;

import com.test.mysql.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityUser extends Users implements UserDetails {

    private static final long serialVersionUID = 1L;

    public SecurityUser(Users user) {
        if (user != null) {
            this.setUserid(user.getUserid());
            this.setUsername(user.getUsername());
            this.setUsercellphone(user.getUsercellphone());
            this.setEmail(user.getEmail());
            this.setPassword(user.getPassword());
            this.setPostion(user.getPostion());
            this.setAddtime(user.getAddtime());
            this.setLastlogin(user.getLastlogin());
            this.setLastip(user.getLastip());
            this.setDelflag(user.getDelflag());
        }
    }

    //获取分配的角色
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.getPostion());
        authorities.add(authority);
        return authorities;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
