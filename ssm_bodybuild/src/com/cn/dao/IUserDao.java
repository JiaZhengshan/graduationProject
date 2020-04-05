// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.dao;

import com.cn.pojo.Teach;
import com.cn.pojo.Admin;
import java.util.Map;
import java.util.List;
import com.cn.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao
{
    User userLogin(@Param("account") String p0, @Param("pwd") String p1);
    
    List<Map<String, Object>> findUserByAccount(String p0);
    
    List<Map<String, Object>> findClass();
    
    List<Map<String, Object>> findSeTeach(Integer p0);
    
    void chooseTeach(@Param("id") Integer p0, @Param("cid") Integer p1, @Param("uid") Integer p2);
    
    void chooseClass(@Param("username") String p0, @Param("cid") Integer p1);
    
    void updateUserInfo(@Param("id") Integer p0, @Param("account") String p1, @Param("sex") Integer p2, @Param("age") Integer p3, @Param("name") String p4, @Param("pwd") String p5, @Param("tel") String p6, @Param("address") String p7);
    
    Admin adminLogin(@Param("name") String p0, @Param("pwd") String p1);
    
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
    
    void upTeach(@Param("id") Integer p0, @Param("tname") String p1, @Param("cid") Integer p2, @Param("ttel") String p3, @Param("taddress") String p4);
    
    void addAppInfo(String p0);
    
    void delApp(Integer p0);
}
