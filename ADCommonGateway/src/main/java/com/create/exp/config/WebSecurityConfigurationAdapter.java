package com.create.exp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private WebSecurityConfiguration webSecurityConfiguration;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
        http
       .csrf().disable()
       .authorizeRequests().anyRequest().authenticated()
       .and()
       .httpBasic();
    }
  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
            .withUser(webSecurityConfiguration.getUsername())
            .password("{noop}"+webSecurityConfiguration.getPassword())
            .roles("APPS");
    }
}
