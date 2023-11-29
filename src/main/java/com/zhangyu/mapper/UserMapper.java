package com.zhangyu.mapper;

import com.zhangyu.model.UserForMybatis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<UserForMybatis> findAll();
}
