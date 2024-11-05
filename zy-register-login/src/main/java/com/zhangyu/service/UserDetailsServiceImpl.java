package com.zhangyu.service;

import com.zhangyu.domain.entity.SysUser;
import com.zhangyu.domain.model.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户验证处理
 *
 * @author ruoyi
 */

//UserDetailsService: 这是Spring Security的一个接口，用于根据用户名加载用户信息。你需要实现这个接口来提供用户验证的逻辑。
//loadUserByUsername: 这是接口中定义的方法，根据用户名返回用户信息。如果找不到用户，抛出UsernameNotFoundException异常。
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private SysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        // 根据username从数据库查询出user详细信息
//        SysUser user = new SysUser();
        System.out.println("username：" + username);

        SysUser user = null;

        try {
            user = userService.selectUserByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createLoginUser(user);
    }

    public UserDetails createLoginUser(SysUser user)
    {
        return new LoginUser(user.getUserId(), user.getDeptId(), user);
    }
}
