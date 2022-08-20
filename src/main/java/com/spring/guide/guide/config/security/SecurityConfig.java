package com.spring.guide.guide.config.security;

import javax.servlet.FilterChain;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.guide.guide.config.security.jwt.JwtAuthenticationFilter;
import com.spring.guide.guide.config.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    
    private final JwtTokenProvider provider;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .httpBasic().disable()
            .csrf().disable()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()
            .antMatchers("/swagger-ui/**", "/h2-console/**").permitAll()
            .antMatchers("/product/**").permitAll()
            .and()

            .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
            .and()
            .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint())
            .and()

            .addFilterBefore(new JwtAuthenticationFilter(provider), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
