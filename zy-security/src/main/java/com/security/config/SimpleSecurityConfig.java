package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SimpleSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated()  // 所有请求都需要登录
                )
                .formLogin(form -> form
                        .permitAll()  // 允许所有用户访问默认的登录页面
                )
                .logout(logout -> logout
                        .permitAll()  // 允许所有用户访问默认的登出页面
                );
        return http.build();
    }
}
