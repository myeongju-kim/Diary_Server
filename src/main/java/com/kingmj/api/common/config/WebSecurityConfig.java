package com.kingmj.api.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  @Bean
  public PasswordEncoder getPasswordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    return  http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/swagger-ui.html", "/webjars/**", "/swagger-resources/**", "/v3/api-docs/**").permitAll()
        .antMatchers(HttpMethod.POST, "/api/v1/accounts", "/api/v1/accounts/login", "/api/v1/accounts/logout").permitAll()
        .antMatchers(HttpMethod.GET, "/api/v1/users/**").hasAnyRole("USER")
        .and().build();
  }

}
