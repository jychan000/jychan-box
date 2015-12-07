package com.jychan.box.springboot.example.service;

import com.jychan.box.springboot.example.domain.User;

import java.util.List;

/**
 * @author Raymond
 * @version 15/12/7 13:17
 * @E-mail:415683089@qq.com
 */
public interface UserService {

    public List<User> findAll();

    public User findById(int id);
}
