package com.lu.service;

import com.lu.pojo.User;

public interface UserService {

    User getUserById(int id);

    /**
     * 向数据库添加user
     * @param user 用户对象
     * @return
     */
    int addUser(User user);

    int updateUser(User user);
}
