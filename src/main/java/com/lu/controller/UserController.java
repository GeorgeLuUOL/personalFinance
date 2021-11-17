package com.lu.controller;

import com.lu.aop.SimpleLog;
import com.lu.mapper.UserMapper;
import com.lu.pojo.User;
import com.lu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;



    @GetMapping("/getUser")
    public User getUser(@RequestParam Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        return userList;
    }

    //添加一个用户
    @SimpleLog(message = "添加了用户")
    @PostMapping(value = "/addUser" )
    public String addUser( @RequestBody User user) {
        userService.addUser(user);
        return "ok";
    }

    //修改一个用户
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
       userService.updateUser(user);
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        //userMapper.deleteUser(7);

        return "ok";
    }
}
