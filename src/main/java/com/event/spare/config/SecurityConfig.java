package com.event.spare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public static PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Configuration
	@Order(1)
	public static class AdminUserSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.antMatcher("/eod/**")
	        .authorizeRequests()
	        .anyRequest()
	        .hasRole("ADMIN")
	         
	        .and()
	        .formLogin()
	        .loginPage("/eod/signin")
	        .loginProcessingUrl("/eod/admin_signin")
	        .failureUrl("/eod/signin?error=loginError")
	        .defaultSuccessUrl("/eod/")
	        .permitAll()
	         
	        .and()
	        .logout()
	        .logoutUrl("/eod/eod_signout")
	        .logoutSuccessUrl("/eod/signin")
	        .deleteCookies("JSESSIONID")
	         
	        .and()
	        .exceptionHandling()
	        .accessDeniedPage("/403")
	         
	        .and()
	        .csrf().disable();
			// @formatter:on
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth
        	.inMemoryAuthentication()
                .withUser("admin")
	                .password(encoder().encode("password"))
	                .roles("ADMIN");
		}
		
	}
	
	@Configuration
	@Order(2)
	public static class NormalUserSecurityConfig extends WebSecurityConfigurerAdapter {
		
		public NormalUserSecurityConfig() {
			super();
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.antMatcher("/event/register/**")
	        .authorizeRequests()
	        .anyRequest()
	        .hasRole("ADMIN")
	         
	        .and()
	        .formLogin()
	        .loginPage("/signin")
	        .loginProcessingUrl("/event/register/user_signin")
	        .failureUrl("/signin?error=loginError")
	        .defaultSuccessUrl("/")
	        .permitAll()
	         
	        .and()
	        .logout()
	        .logoutUrl("/eod/eod_signout")
	        .logoutSuccessUrl("/eod/signin")
	        .deleteCookies("JSESSIONID")
	         
	        .and()
	        .exceptionHandling()
	        .accessDeniedPage("/403")
	         
	        .and()
	        .csrf().disable();
			// @formatter:on
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth
        	.inMemoryAuthentication()
                .withUser("user")
	                .password(encoder().encode("password"))
	                .roles("USER");
		}
		
	}
	
}
