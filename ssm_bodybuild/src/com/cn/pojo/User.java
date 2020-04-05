// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.pojo;

import java.util.List;

public class User
{
    private Integer id;
    private String name;
    private String pwd;
    private String account;
    private String tel;
    private String address;
    private Integer age;
    private Integer sex;
    private Integer uclass;
    private Integer uteach;
    private List<Teach> teachs;
    private List<Course> courses;
    
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
    
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(final Integer age) {
        this.age = age;
    }
    
    public void setPwd(final String pwd) {
        this.pwd = pwd;
    }
    
    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(final String account) {
        this.account = account;
    }
    
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(final String tel) {
        this.tel = tel;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(final Integer sex) {
        this.sex = sex;
    }
    
    public Integer getUclass() {
        return this.uclass;
    }
    
    public void setUclass(final Integer uclass) {
        this.uclass = uclass;
    }
    
    public Integer getUteach() {
        return this.uteach;
    }
    
    public void setUteach(final Integer uteach) {
        this.uteach = uteach;
    }
    
    public List<Teach> getTeachs() {
        return this.teachs;
    }
    
    public void setTeachs(final List<Teach> teachs) {
        this.teachs = teachs;
    }
    
    public List<Course> getCourses() {
        return this.courses;
    }
    
    public void setCourses(final List<Course> courses) {
        this.courses = courses;
    }
}
