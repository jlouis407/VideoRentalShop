package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Order(1)
public class ClerkConfigurationAdapter extends WebSecurityConfigurerAdapter {
	
	public ClerkConfigurationAdapter() {
		super();
	}
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication().withUser("clerk")
		 	.password(encoder().encode("clerk"))
		 	.roles("CLERK");
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
	 
	 @Bean
	 public static PasswordEncoder encoder() {
		 return new BCryptPasswordEncoder();
	 }

}
