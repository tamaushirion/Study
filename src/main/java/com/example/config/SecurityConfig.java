package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/* セキュリティ対象外 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web
		  .ignoring()
		    .antMatchers("/webjars/**")
		    .antMatchers("/css/**")
		    .antMatchers("/js/**")
		    .antMatchers("/h2-console/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/* ログイン不要ページ */
		http
		  .authorizeRequests()
		    .antMatchers("/login").permitAll()
		    .antMatchers("/signup").permitAll()
		    .anyRequest().authenticated();
		
		//ログイン処理
		http
		  .formLogin()
		    .loginProcessingUrl("/login")
		    .loginPage("/login")
		    .successHandler(loginSuccessHandler)
		    .failureUrl("/login?error")
		    .usernameParameter("email")
		    .passwordParameter("password");
		
		//ログアウト処理
		http
		  .logout()
		  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		  .logoutUrl("/logout")
		  .logoutSuccessUrl("/logout?logout");
	}

	/* 認証の設定 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = passwordEncoder();
		
		auth
		  .userDetailsService(userDetailsService)
		  .passwordEncoder(encoder);
	}
}
