// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.pojo;

public class Admin
{
    Integer id;
    String name;
    String pwd;
    String lastlogintime;
    
    public String getLastlogintime() {
        return this.lastlogintime;
    }
    
    public void setLastlogintime(final String lastlogintime) {
        this.lastlogintime = lastlogintime;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getPwd() {
        return this.pwd;
    }
    
    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }
}
