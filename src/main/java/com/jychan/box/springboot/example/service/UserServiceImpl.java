package com.jychan.box.springboot.example.service;

import com.jychan.box.springboot.example.domain.User;
import com.jychan.box.springboot.example.persistence.dbjychan.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Raymond
 * @version 15/12/7 13:18
 * @E-mail:415683089@qq.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }
}

