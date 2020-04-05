// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.service;

import com.cn.pojo.Teach;
import com.cn.pojo.Admin;
import java.util.Map;
import java.util.List;
import com.cn.pojo.User;

public interface IUserService
{
    User userLogin(String p0, String p1);
    
    List<Map<String, Object>> findUserByAccount(String p0);
    
    List<Map<String, Object>> findClass();
    
    List<Map<String, Object>> findSeTeach(Integer p0);
    
    void chooseTeach(Integer p0, Integer p1, Integer p2);
    
    void chooseClass(String p0, Integer p1);
    
    void updateUserInfo(Integer p0, String p1, Integer p2, Integer p3, String p4, String p5, String p6, String p7);
    
    Admin adminLogin(String p0, String p1);
    
    void setTime(String p0);
    
    List<Map<String, Object>> countUser();
    
    List<Map<String, Object>> countTeach();
    
    List<Map<String, Object>> countApparatus();
    
    List<User> getSex();
    
    List<Map<String, Object>> findUser();
    
    List<Map<String, Object>> teachTable();
    
    List<Map<String, Object>> apparatusTable();
    
    List<User> findAccount(String p0);
    
    void registerUser(User p0);
    
    void delUser(Integer p0);
    
    void addTeachInfo(Teach p0);
    
    void delTeach(Integer p0);
    
    void upTeach(Integer p0, String p1, Integer p2, String p3, String p4);
    
    void addAppInfo(String p0);
    
    void delApp(Integer p0);
}
