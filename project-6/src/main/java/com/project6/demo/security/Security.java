package com.project6.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Habib
 * @on 10/13/21 - 8:16 AM
 */
@Configuration
public class Security extends WebSecurityConfigurerAdapter {
  /*  @Override
    protected void configure(HttpSecurity auth) throws Exception {
        auth.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
    }

*/ //login with form
/*    @Override // HttpSecurity ***
    protected void configure(HttpSecurity auth) throws Exception {
        auth.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }// httpBasic*/

    @Override
    //.antMatchers("/css/**")
    //                .önemli
    protected void configure(HttpSecurity auth) throws Exception {
        auth.authorizeRequests()
                .antMatchers("/css/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .permitAll();
             /*   .and()
                .httpBasic();*/ // biz login sayfası oluşturduğumuz zaman httpBasic kullanmamamiz  lazım çünkü o default değerler için
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("habib")
                .password("{noop}123")
                .roles("USER");
    }
}
