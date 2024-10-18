package com.zhangyu.mapper;

import com.zhangyu.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper {

    int insertUser(SysUser user);

}
