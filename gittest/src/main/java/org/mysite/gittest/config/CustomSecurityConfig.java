package org.mysite.gittest.config;

import lombok.extern.log4j.Log4j2;
import org.mysite.gittest.security.handler.Custom403Handler;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@Log4j2
public class CustomSecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, HttpSecurity httpSecurity) throws Exception {
    http.formLogin().loginPage("/member/login").successForwardUrl("/mypage");

    http.authorizeHttpRequests(request->request
        .requestMatchers("/","/member/login","/img/**","/js/**","/font/**","/css/**","/assets/**").permitAll()
        .anyRequest().authenticated());

    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
    http.csrf().disable();
    return http.build();
  }
  @Bean
  AccessDeniedHandler accessDeniedHandler() {
    return new Custom403Handler();
  }
//  @Bean
//  public WebSecurityCustomizer webSecurityCustomizer() {
//    log.info("-----------WebSecurityCustomizer-----------");
//    //static 폴더 안에 존재하는 정적리소스는 로그인 과정을 거치지 않고 실행 가능
//    return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//  }
}
