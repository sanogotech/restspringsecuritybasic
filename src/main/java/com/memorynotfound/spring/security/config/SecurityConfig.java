package com.memorynotfound.spring.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

   public static final String REALM_NAME = "memorynotfound.com";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeRequests()
                    .anyRequest().authenticated()
                .and()
                    .httpBasic()
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                    .password("password")
                    .roles("USER")
            .and()
                .withUser("manager")
                    .password("password")
                    .credentialsExpired(true)
                    .accountExpired(true)
                    .accountLocked(true)
                    .authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES")
                    .roles("MANAGER");
    }

}