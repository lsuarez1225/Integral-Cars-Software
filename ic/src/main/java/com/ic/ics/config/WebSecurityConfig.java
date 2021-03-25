package com.ic.ics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ic.ics.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Necesario para evitar que la seguridad se aplique a los recursos como css, img y js.
	String[] resources = new String[] {
		"/include/**","/css/**","/icons/**","**/img/**","/js/**","/layers/**"
	};

	@Autowired
	MyUserDetailsService userDetailsService;
	
	// Registra el service para usuarios y encriptador de contraseña.
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .authorizeRequests() .antMatchers(resources).permitAll()
	 * .antMatchers("/","/index").permitAll()
	 * .antMatchers("/admin*").access("hasRole('ADMIN')")
	 * .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
	 * .antMatchers("/home*").hasAnyRole("ADMIN", "USER")
	 * .anyRequest().authenticated() .and() .formLogin() .loginPage("/login")
	 * .permitAll() .defaultSuccessUrl("/home")
	 * .failureUrl("/login?invalidCredentialss=true") .usernameParameter("username")
	 * .passwordParameter("password") .and() .logout() .permitAll()
	 * .logoutSuccessUrl("/login?logout"); }
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests()
			//.antMatchers(resources).permitAll()
			.antMatchers("/").permitAll()
			.and()
			.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home").failureUrl("/login?invalidCredentials=true");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
