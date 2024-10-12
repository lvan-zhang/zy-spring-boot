package com.zhangyu.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户登录对象
 * 
 * @author ruoyi
 */
@Getter
@Setter
public class LoginBody
{
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid;
}
