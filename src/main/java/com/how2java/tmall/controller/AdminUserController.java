package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.AdminUser;
import com.how2java.tmall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RequestMapping("")
@Controller
public class AdminUserController {

    @Autowired
    AdminUserService adminUserService;

    @RequestMapping("adminLogin")
    public String adminLogin(HttpSession session, String name, String password, Model model){
        name = HtmlUtils.htmlEscape(name);
        AdminUser admin = adminUserService.get(name,password);
        if (null == admin){
            String msg = "账号密码错误!";
            model.addAttribute("msg",msg);
            return "admin/adminLogin";
        }
        session.setAttribute("adminUser",admin);
        return "redirect:/admin_category_list";
    }
}
