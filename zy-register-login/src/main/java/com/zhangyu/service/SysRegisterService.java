package com.zhangyu.service;

import com.zhangyu.constant.UserConstants;
import com.zhangyu.domain.entity.SysUser;
import com.zhangyu.domain.model.RegisterBody;
import com.zhangyu.mapper.SysUserMapper;
import com.zhangyu.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRegisterService {
    @Autowired
    private SysUserMapper sysUserMapper;
    public String register (RegisterBody registerBody) {
        String msg = "", username = registerBody.getUsername(), password = registerBody.getPassword();
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        if (StringUtils.isEmpty(username))
        {
            msg = "用户名不能为空";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "用户密码不能为空";
        }
        else if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            msg = "账户长度必须在2到20个字符之间";
        }
        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            msg = "密码长度必须在5到20个字符之间";
        }
        else {
            sysUser.setNickName(username);
            sysUser.setPassword(password);
            boolean regFlag = registerUser(sysUser);
            if (!regFlag)
            {
                msg = "注册失败,请联系系统管理人员";
            }
        }
        return msg;
    }
    public boolean registerUser (SysUser user) {
        return sysUserMapper.insertUser(user) > 0;
    }
}
