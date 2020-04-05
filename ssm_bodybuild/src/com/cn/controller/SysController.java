package com.cn.controller;

import com.cn.pojo.Teach;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cn.pojo.User;

import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import com.cn.pojo.Admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.cn.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/sys" })
public class SysController
{
    @Resource
    private IUserService userService;
    SimpleDateFormat df;
    
    public SysController() {
        this.df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
    
    @ResponseBody
    @RequestMapping({ "/loginAdmin" })
    public String toIndex(Admin admin, final HttpSession session) {
        admin = this.userService.adminLogin(admin.getName(), admin.getPwd());
        if (admin != null) {
            session.setAttribute("lastLoginTime", (Object)admin.getLastlogintime());
            session.setAttribute("account", (Object)"123");
            this.userService.setTime(this.df.format(new Date()));
            return "true";
        }
        return "false";
    }
    
    @RequestMapping({ "/ForwardAdmin" })
    public String loginForward(final HttpSession session) {
        final List<Map<String, Object>> countUserList = this.userService.countUser();
        session.setAttribute("countUser", (Object)countUserList);
        final List<Map<String, Object>> countTeachList = this.userService.countTeach();
        session.setAttribute("countTeach", (Object)countTeachList);
        final List<Map<String, Object>> countApparatusList = this.userService.countApparatus();
        session.setAttribute("countApparatus", (Object)countApparatusList);
        return "sys/main";
    }
    
    @RequestMapping({ "/userTable" })
    public String userTable(final HttpSession session) {
        final List<Map<String, Object>> findUserList = this.userService.findUser();
        session.setAttribute("findUserList", (Object)findUserList);
        return "sys/userTable";
    }
    
    @RequestMapping({ "/teachTable" })
    public String teachTable(final HttpSession session) {
        final List<Map<String, Object>> findUserList = this.userService.teachTable();
        session.setAttribute("findTeachList", (Object)findUserList);
        return "sys/teachTable";
    }
    
    @RequestMapping({ "/apparatusTable" })
    public String apparatusTable(final HttpSession session) {
        final List<Map<String, Object>> findUserList = this.userService.apparatusTable();
        session.setAttribute("findApparatusList", (Object)findUserList);
        return "sys/apparatusTable";
    }
    
    @RequestMapping({ "/exit" })
    public String exit(final HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    @ResponseBody
    @RequestMapping({ "/getSex" })
    public List<User> getSex() {
        final List<User> list = this.userService.getSex();
        return list;
    }
    
    @ResponseBody
    @RequestMapping({ "/delUser" })
    public String delUser(final Integer id) {
        this.userService.delUser(id);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/delTeach" })
    public String delTeach(final Integer id) {
        if (id != 12) {
            this.userService.delTeach(id);
        }
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/delApp" })
    public String delApp(final Integer id) {
        this.userService.delApp(id);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/loginForwardAdmin" })
    public String loginForwardAdmin() {
        return "true";
    }
    
    @RequestMapping({ "/upUser" })
    public String upUser(final Integer id, final String account, final Integer sex, final Integer age, final String name, final String pwd, final String tel, final String address, final HttpSession session) {
        String str = null;
        String str2 = null;
        str = new String(name);
        str2 = new String(address);
        final List<Object> list = new ArrayList<Object>();
        list.add(id);
        list.add(account);
        list.add(sex);
        list.add(age);
        list.add(str);
        list.add(pwd);
        list.add(tel);
        list.add(str2);
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }
        session.setAttribute("upList", (Object)list);
        return "sys/upUser";
    }
    
    @RequestMapping({ "/upTeach" })
    public String upTeach(final Integer id, final String tname, final Integer cid, final String ttel, final String taddress, final HttpSession session) {
        final List<Object> list = new ArrayList<Object>();
        list.add(id);
        list.add(tname);
        list.add(cid);
        list.add(ttel);
        list.add(taddress);
        session.setAttribute("upTeachList", (Object)list);
        return "sys/upTeach";
    }
    
    @ResponseBody
    @RequestMapping({ "/registerUser" })
    public String registerUser(final User user) {
        final List<User> id = this.userService.findAccount(user.getAccount());
        if (id.size() != 0) {
            return "false";
        }
        user.setUclass(1);
        user.setUteach(12);
        this.userService.registerUser(user);
        return "true";
    }
    
    @RequestMapping({ "/addUser" })
    public String addUser() {
        return "sys/addUser";
    }
    
    @RequestMapping({ "/addTeach" })
    public String addTeach() {
        return "sys/addTeach";
    }
    
    @RequestMapping({ "/addApp" })
    public String addApp() {
        return "sys/addApp";
    }
    
    @ResponseBody
    @RequestMapping({ "/upUserInfo" })
    public String upUserInfo(final Integer id, final String account, final Integer sex, final Integer age, final String name, final String pwd, final String tel, final String address) {
        this.userService.updateUserInfo(id, account, sex, age, name, pwd, tel, address);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping(value = { "/upTeachInfo" }, method = { RequestMethod.POST })
    public String upTeach(final Integer id, final String tname, final Integer cid, final String ttel, final String taddress) {
        this.userService.upTeach(id, tname, cid, ttel, taddress);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/addTeachInfo" })
    public String addTeachInfo(final Teach teach) {
        this.userService.addTeachInfo(teach);
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/addAppInfo" })
    public String addAppInfo(final String aname) {
        this.userService.addAppInfo(aname);
        return "true";
    }
    
    @RequestMapping({ "/JumpUserSearch" })
    public String jumpUserSearch() {
        return "true";
    }
}
