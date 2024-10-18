package com.zhangyu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/hello", "/login", "/register").permitAll()
//                        .anyRequest().authenticated()  // 所有请求都需要登录
                    .anyRequest().permitAll()  // 允许所有请求不需要认证
            )
            .formLogin(form -> form
                    .permitAll()  // 允许所有用户访问默认的登录页面
            )
            .logout(logout -> logout
                    .permitAll()  // 允许所有用户访问默认的登出页面
            )
            .csrf(csrf -> csrf.disable()); // 这个不加的话用postman掉不通
        return http.build();
    }
}
