package com.dudu.shop.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
    //csrf 다른사이트에서 api를 가져다 쓸수없게 해주는것
    //jwt는 fetch에서 header로 보냄
    //지금은 세션방식으로
    http.csrf((csrf)->csrf.disable()); 
    http.authorizeHttpRequests((authorize)->
            authorize.requestMatchers("/**").permitAll()
    );

    return http.build();
  }


}
