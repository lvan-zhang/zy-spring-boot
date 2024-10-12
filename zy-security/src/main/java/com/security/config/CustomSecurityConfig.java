package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/login", "/resources/**", "/css/**").permitAll()  // 放行静态资源和登录页面
                        .anyRequest().authenticated()  // 其他请求都需要身份认证
                )
                .formLogin(form -> form
                        .loginPage("/login")  // 自定义登录页面
                        .permitAll()  // 允许所有用户访问登录页面
                        .defaultSuccessUrl("/home", true)  // 登录成功后重定向到 /home
                )
                .logout(logout -> logout
                        .permitAll()  // 允许所有用户访问登出功能
                );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        var admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
