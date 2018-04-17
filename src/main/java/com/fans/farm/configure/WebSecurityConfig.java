package com.fans.farm.configure;

import com.fans.farm.security.JWTAuthenticationFilter;
import com.fans.farm.security.JWTLoginFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: Ike.Fan
 * @date: 2018/4/4.
 */
@Configuration
@Order(SecurityProperties.IGNORED_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService mUserDetailsService;

    public WebSecurityConfig(UserDetailsService userDetailsService){
        this.mUserDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers( "/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTLoginFilter(authenticationManager()))
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
//        http.csrf().ignoringAntMatchers("http://localhost").disable();

        http.authorizeRequests()
                .antMatchers("**/*").permitAll()
                .and()
                .httpBasic().disable()
                .csrf().disable();
        http.requestMatchers()
                .antMatchers(HttpMethod.OPTIONS, "/oauth/token", "/rest/**", "/api/farm/**", "/**")
                .and()
                .csrf().disable();

    }
}
