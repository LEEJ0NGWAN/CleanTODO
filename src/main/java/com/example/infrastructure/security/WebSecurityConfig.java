package com.example.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    public void configure(WebSecurity web) {

        web
        .ignoring()
        .antMatchers("/css/**", "/h2-console/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/login", "/signup", "/favicon.ico").permitAll()
        .antMatchers("/**").authenticated()
        .and()
        .formLogin().loginPage("/login")
        .successHandler(loginSuccessHandler())
        .failureForwardUrl("/fail")
        .and()
        .logout()
        .logoutUrl("/logout");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordAuthenticationProvider
    passwordAuthenticationProvider() {

        return new PasswordAuthenticationProvider(
            userDetailsService, bCryptPasswordEncoder());
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {

        return new LoginSuccessHandler();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) {

        builder.authenticationProvider(passwordAuthenticationProvider());
    }
}
