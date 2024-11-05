package com.zhangyu.service;

import com.zhangyu.constant.CacheConstants;
import com.zhangyu.constant.UserConstants;
import com.zhangyu.domain.model.LoginBody;
import com.zhangyu.domain.model.LoginUser;
import com.zhangyu.exception.ServiceException;
import com.zhangyu.exception.user.CaptchaException;
import com.zhangyu.exception.user.CaptchaExpireException;
import com.zhangyu.exception.user.UserNotExistsException;
import com.zhangyu.exception.user.UserPasswordNotMatchException;
import com.zhangyu.utils.RedisUtil;
import com.zhangyu.utils.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SysLoginService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    public String login (LoginBody loginBody) {
        String username = loginBody.getUsername(), password = loginBody.getPassword(), uuid = loginBody.getUuid(), captchaCode = loginBody.getCode();

        // 验证码校验
        validateCaptcha(username, captchaCode, uuid);
        // 登录前置校验
        loginPreCheck(username, password);

        // 用户验证
        Authentication authentication = null;

        try {
            // 创建一个未认证的 UsernamePasswordAuthenticationToken
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername，调用 AuthenticationManager 进行认证
            authentication = authenticationManager.authenticate(token);
            // 如果认证成功，将其存储到 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                throw new UsernameNotFoundException("用户不存在");
            }
            else
            {
                try {
                    throw new ServiceException(StringUtils.isEmpty(e.getMessage()) ? "" : e.getMessage());
                } catch (ServiceException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        finally
        {
            SecurityContextHolder.clearContext();
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        System.out.println("userId:" + loginUser.getUser().getUsername());
        String token = tokenService.createToken(loginUser);
        System.out.println("token:" + token);

        return token;
    }

    public void validateCaptcha (String username, String captchaCode, String uuid) {
        String validKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;
        String validCode = (String) redisUtil.get(validKey);
        if (StringUtils.isEmpty(captchaCode)) {
            throw new CaptchaExpireException();
        }
        redisUtil.deleteObject(validKey);
        if (!validCode.equalsIgnoreCase(captchaCode)) {
            throw new CaptchaException();
        }
    }

    /**
     * 登录前置校验
     * @param username 用户名
     * @param password 用户密码
     */
    public void loginPreCheck(String username, String password)
    {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
        {
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
        {
            throw new UserPasswordNotMatchException();
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH)
        {
            throw new UserPasswordNotMatchException();
        }
    }

}
