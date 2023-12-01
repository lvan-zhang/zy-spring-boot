package com.zhangyu.controller;

import com.zhangyu.mapper.UserMapper;
import com.zhangyu.model.UserForJpa;
import com.zhangyu.model.UserForMybatis;
import com.zhangyu.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "用户模块", description = "用户模块的描述")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("getAllForJpa")
    @Operation(summary = "获取用户信息-jpa方式", description = "以jpa的方式获取用户")
    public List<UserForJpa> getAllUsersForJpa() {
        return userRepository.findAll();
    }

    @GetMapping("getAllForMybatis")
    @Operation(summary = "获取用户信息-Mybatis方式", description = "以Mybatis的方式获取用户")
    public List<UserForMybatis> getAllUsersForMybatis() {
        return userMapper.findAll();
    }
}
