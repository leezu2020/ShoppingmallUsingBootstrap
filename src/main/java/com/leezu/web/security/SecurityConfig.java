package com.leezu.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.leezu.web.user.service.UserServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserServiceImp userService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// 리소스는 인증 무시
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 테스트 위한 임시 csrf 설정 막기
			http.csrf().disable();
		
		// 임시로 모든 페이지 허용
		http.authorizeRequests()
			.antMatchers("/","/login/**", "/**", "/customer/**").permitAll()
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll()
			
		// 로그인 설정
			.and()
			.formLogin()
			.loginPage("/login/userLogin")
			.permitAll()
			.loginProcessingUrl("/login/userLogin")
			.usernameParameter("userID")
			.passwordParameter("userPassword")
			.defaultSuccessUrl("/")
		
		// 로그아웃 설정
			.and()
			.logout()
		//	.logoutRequestMatcher(new AntPathRequestMatcher("/login/userLogout"))
			.logoutSuccessUrl("/")
			.logoutUrl("/logout")
			.deleteCookies("JSESSIONID")
			.invalidateHttpSession(true);
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService);
	}
}
