package com.lu.utils;

import com.lu.pojo.User;
import org.apache.shiro.subject.Subject;

public class SecurityUtils {
    public static User getUser(){
        Subject subject = org.apache.shiro.SecurityUtils.getSubject();
        if(subject.getPrincipal() == null){
            return null;
        }
        Object loginUser = subject.getPrincipal();
        return (User) loginUser;
    }
}
