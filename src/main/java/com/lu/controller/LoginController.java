package com.lu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/userLogin")
    public String userLogin(){
        return "login success";
    }
}
