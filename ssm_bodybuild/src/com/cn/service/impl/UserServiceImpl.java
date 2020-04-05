// 
// Decompiled by Procyon v0.5.29
// 

package com.cn.service.impl;

import com.cn.pojo.Teach;
import com.cn.pojo.Admin;
import java.util.Map;
import java.util.List;
import com.cn.pojo.User;
import javax.annotation.Resource;
import com.cn.dao.IUserDao;
import org.springframework.stereotype.Service;
import com.cn.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService
{
    @Resource
    private IUserDao userDao;
    
    @Override
    public User userLogin(final String account, final String pwd) {
        return this.userDao.userLogin(account, pwd);
    }
    
    @Override
    public List<Map<String, Object>> findUserByAccount(final String account) {
        return this.userDao.findUserByAccount(account);
    }
    
    @Override
    public List<Map<String, Object>> findClass() {
        return this.userDao.findClass();
    }
    
    @Override
    public List<Map<String, Object>> findSeTeach(final Integer id) {
        return this.userDao.findSeTeach(id);
    }
    
    @Override
    public void chooseTeach(final Integer id, final Integer cid, final Integer uid) {
        this.userDao.chooseTeach(id, cid, uid);
    }
    
    @Override
    public void updateUserInfo(final Integer id, final String account, final Integer sex, final Integer age, final String name, final String pwd, final String tel, final String address) {
        this.userDao.updateUserInfo(id, account, sex, age, name, pwd, tel, address);
    }
    
    @Override
    public Admin adminLogin(final String name, final String pwd) {
        return this.userDao.adminLogin(name, pwd);
    }
    
    @Override
    public void setTime(final String format) {
        this.userDao.setTime(format);
    }
    
    @Override
    public List<Map<String, Object>> countUser() {
        return this.userDao.countUser();
    }
    
    @Override
    public List<Map<String, Object>> countTeach() {
        return this.userDao.countTeach();
    }
    
    @Override
    public List<User> getSex() {
        return this.userDao.getSex();
    }
    
    @Override
    public List<Map<String, Object>> findUser() {
        return this.userDao.findUser();
    }
    
    @Override
    public List<Map<String, Object>> teachTable() {
        return this.userDao.teachTable();
    }
    
    @Override
    public List<Map<String, Object>> apparatusTable() {
        return this.userDao.apparatusTable();
    }
    
    @Override
    public List<Map<String, Object>> countApparatus() {
        return this.userDao.countApparatus();
    }
    
    @Override
    public List<User> findAccount(final String account) {
        return this.userDao.findAccount(account);
    }
    
    @Override
    public void registerUser(final User user) {
        this.userDao.registerUser(user);
    }
    
    @Override
    public void delUser(final Integer id) {
        this.userDao.delUser(id);
    }
    
    @Override
    public void addTeachInfo(final Teach teach) {
        this.userDao.addTeachInfo(teach);
    }
    
    @Override
    public void delTeach(final Integer id) {
        this.userDao.delTeach(id);
    }
    
    @Override
    public void upTeach(final Integer id, final String tname, final Integer cid, final String ttel, final String taddress) {
        this.userDao.upTeach(id, tname, cid, ttel, taddress);
    }
    
    @Override
    public void addAppInfo(final String aname) {
        this.userDao.addAppInfo(aname);
    }
    
    @Override
    public void delApp(final Integer id) {
        this.userDao.delApp(id);
    }
    
    @Override
    public void chooseClass(final String username, final Integer cid) {
        this.userDao.chooseClass(username, cid);
    }
}
