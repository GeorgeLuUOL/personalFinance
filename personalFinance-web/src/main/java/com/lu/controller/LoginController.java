package com.lu.controller;

import com.lu.utils.RedisUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
//@RequestMapping("/login")
public class LoginController {
    private Logger logger= LoggerFactory.getLogger(getClass());;
    @Autowired
    private RedisUtils redisUtils;
    @RequestMapping("/login")
    public String login() {
        return "这是登录页面，使用toLogin接口登录";
    }

    @RequestMapping("/tologin")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password, Model model) {
        logger.info("username{}, pwd",username,password);
        //获取一个用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);//执行登录的方法，如果没有异常就说明ok了
            redisUtils.set("User:"+username,token,86400L, TimeUnit.SECONDS);

            return "登录成功";
        } catch (UnknownAccountException e) {//用户名不存在
            model.addAttribute("msg","用户名错误");
            return "用户名或密码错误";
        } catch (IncorrectCredentialsException e) {//密码不存在
            model.addAttribute("msg","密码错误");
            return "用户名或密码错误";
        }
    }
    //这是redis测试代
    @RequestMapping("/test")
    public String testRedis(){

        return "";
    }
}
