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
@Order(2)
public class CustomerConfigurationAdapter extends WebSecurityConfigurerAdapter {
	
	public CustomerConfigurationAdapter() {
		super();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("customer")
		 .password(encoder2().encode("customer"))
		 .roles("CUSTOMER");
	}
	 
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/customer*")
          .authorizeRequests()
          .anyRequest()
          .hasRole("CUSTOMER")
          
          .and()
          .formLogin()
          .loginPage("/loginCustomer")
          .loginProcessingUrl("/customer_login")
          .failureUrl("/loginCustomer?error=loginError")
          .defaultSuccessUrl("/customerPage")
          
          .and()
          .logout()
          .logoutUrl("/customer_logout")
          .logoutSuccessUrl("/protectedLinks")
          .deleteCookies("JSESSIONID")
          
          .and()
          .exceptionHandling()
          .accessDeniedPage("/403")
          
          .and()
          .csrf().disable();
    }
	
	@Bean
	 public static PasswordEncoder encoder2() {
		 return new BCryptPasswordEncoder();
	 }


}
