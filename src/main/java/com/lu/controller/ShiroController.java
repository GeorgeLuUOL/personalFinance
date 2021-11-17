package com.lu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ShiroController {
    private Logger logger= LoggerFactory.getLogger(getClass());;
    @RequiresRoles(value = { "admin" })
    @RequestMapping("/getShiroSubject")
    @org.springframework.web.bind.annotation.ResponseBody
    public String getShiroSubject() {
        Subject subject = SecurityUtils.getSubject();
        Object loginUser = subject.getPrincipal();
        // 获取当前登录的用户,如何获取会话中的权限
        return loginUser.toString();
    }

    @RequestMapping("/getDatas")
    @org.springframework.web.bind.annotation.ResponseBody
    public String getDatas() {
        // 获取当前登录的用户,如何获取会话中的权限
      logger.info(SecurityUtils.getSubject().getPrincipal().toString());
        return "获取权限成功";
    }
    // 退出shiro控制

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }

}
