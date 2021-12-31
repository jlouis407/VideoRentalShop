package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	
	public App1ConfigurationAdapter() {
		super();
	}
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/clerk*")
	          .authorizeRequests()
	          .anyRequest()
	          .hasRole("CLERK")
	          
	          .and()
	          .formLogin()
	          .loginPage("/loginClerk")
	          .loginProcessingUrl("/clerk_login")
	          .failureUrl("/loginClerk?error=loginError")
	          .defaultSuccessUrl("/clerkPage")
	          
	          .and()
	          .logout()
	          .logoutUrl("/clerk_logout")
	          .logoutSuccessUrl("/protectedLinks")
	          .deleteCookies("JSESSIONID")
	          
	          .and()
	          .exceptionHandling()
	          .accessDeniedPage("/403")
	          
	          .and()
	          .csrf().disable();
	    }

}
