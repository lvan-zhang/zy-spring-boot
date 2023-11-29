package com.zhangyu.controller;

import com.zhangyu.mapper.UserMapper;
import com.zhangyu.model.UserForJpa;
import com.zhangyu.model.UserForMybatis;
import com.zhangyu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getAllForJpa")
    public List<UserForJpa> getAllUsersForJpa() {
        return userRepository.findAll();
    }

    @GetMapping("getAllForMybatis")
    public List<UserForMybatis> getAllUsersForMybatis() {
        return userMapper.findAll();
    }
}
