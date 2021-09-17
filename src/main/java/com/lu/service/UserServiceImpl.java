package com.lu.service;

import com.lu.mapper.UserMapper;
import com.lu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserById(int id) {
        return userMapper.queryUserById(id);
    }
    @Override
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    @Override
    public  int updateUser(User user){
        return userMapper.updateUser(user);
    }
}
