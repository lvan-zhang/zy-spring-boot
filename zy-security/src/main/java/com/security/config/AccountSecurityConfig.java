package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class AccountSecurityConfig {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .anyRequest().authenticated()  // 所有请求都需要登录
//                )
//                .formLogin(form -> form
//                        .permitAll()  // 允许所有用户访问默认的登录页面
//                )
//                .logout(logout -> logout
//                        .permitAll()  // 允许所有用户访问默认的登出页面
//                );
//        return http.build();
//    }

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

//这个是springboot2的API
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.exceptionHandling().accessDeniedPage( "/unauth.html" );
//        //跳转到自定义的登录页面
//        http.formLogin()
//                //登录页面地址
//                .loginPage( "/login.html" )
//                //登录访问路径
//                .loginProcessingUrl( "/user/login" )
//                //登录成功后跳转路径
//                .defaultSuccessUrl( "/success.html" ).permitAll()
//                //表示访问下面这些路径的时候不需要认证
//                .and().authorizeRequests()
//                .antMatchers( "/","/test/hello","/user/login" ).permitAll()
//                //当前用户，只有具有amdins权限才可以访问这个路径
//                //.antMatchers( "/test/index" ).hasAuthority("admins")
//                //.antMatchers( "/test/index" ).hasAnyAuthority("admins","manager")
//                //
//                //.antMatchers( "/test/index" ).hasRole("sale")
//                //关闭csrf防护
//                .and().csrf().disable();
//
//        http.logout().logoutUrl( "/logout" ).logoutSuccessUrl( "/test/hello" ).permitAll();
//
//    }

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
