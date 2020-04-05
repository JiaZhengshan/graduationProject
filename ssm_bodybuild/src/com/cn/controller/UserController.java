package com.cn.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import javax.servlet.http.HttpSession;
import com.cn.pojo.User;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import com.cn.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/user" })
public class UserController
{
    @Resource
    private IUserService userService;
    
    @ResponseBody
    @RequestMapping({ "/login" })
    public String toIndex(User user, final HttpSession session) {
        final String account = user.getAccount();
        user = this.userService.userLogin(user.getAccount(), user.getPwd());
        if (user != null) {
            final List<Map<String, Object>> list = this.userService.findUserByAccount(account);
            session.setAttribute("userInfo", JSON.toJSON((Object)list));
            final String string = JSON.toJSON((Object)list).toString();
            System.out.println(string);
            session.setAttribute("account", (Object)account);
            return "true";
        }
        return "false";
    }
    
    @RequestMapping({ "/Forward" })
    public String loginForward() {
        return "user/index";
    }
    
    @RequestMapping({ "/exit" })
    public String exit(final HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    @RequestMapping({ "/myInfo" })
    public String myInfo(final HttpSession session) {
        final String account = (String)session.getAttribute("account");
        final List<Map<String, Object>> list = this.userService.findUserByAccount(account);
        session.setAttribute("userInfo", JSON.toJSON((Object)list));
        return "user/index";
    }
    
    @RequestMapping({ "/classTable" })
    public String classTable(final HttpSession session) {
        final List<Map<String, Object>> list = this.userService.findClass();
        session.setAttribute("classInfo", JSON.toJSON((Object)list));
        return "user/classTable";
    }
    
    @RequestMapping({ "/teachList" })
    public String teachList(final HttpSession session) {
        return "user/teachList";
    }
    
    @ResponseBody
    @RequestMapping({ "/selectTeach" })
    public String selectTeach(final HttpSession session, final Integer id) {
        final List<Map<String, Object>> list = this.userService.findSeTeach(id);
        session.setAttribute("SelectTeachInfo", JSON.toJSON((Object)list));
        return "true";
    }
    
    @ResponseBody
    @RequestMapping(value = { "selectClass" }, method = { RequestMethod.POST })
    public String selectClass(final HttpSession session, final Integer id) {
        this.userService.chooseClass(String.valueOf(session.getAttribute("account")), id);
        final List<Map<String, Object>> list = this.userService.findSeTeach(id);
        session.setAttribute("SelectTeachInfo", JSON.toJSON((Object)list));
        final String account = (String)session.getAttribute("account");
        final List<Map<String, Object>> list2 = this.userService.findUserByAccount(account);
        session.setAttribute("userInfo", JSON.toJSON((Object)list2));
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/chooseTeach" })
    public String chooseTeach(final HttpSession session, final Integer id, final Integer cid, final Integer uid) {
        this.userService.chooseTeach(id, cid, uid);
        final String account = (String)session.getAttribute("account");
        final List<Map<String, Object>> list1 = this.userService.findUserByAccount(account);
        session.setAttribute("userInfo", JSON.toJSON((Object)list1));
        return "true";
    }
    
    @ResponseBody
    @RequestMapping({ "/updateUserInfo" })
    public String updateUserInfo(final HttpSession session, final Integer id, final String account, final Integer sex, final Integer age, final String name, final String pwd, final String tel, final String address) {
        this.userService.updateUserInfo(id, account, sex, age, name, pwd, tel, address);
        final List<Map<String, Object>> list1 = this.userService.findUserByAccount(account);
        session.setAttribute("userInfo", JSON.toJSON((Object)list1));
        return "true";
    }
}
