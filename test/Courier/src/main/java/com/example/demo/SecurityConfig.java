package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http.formLogin(login -> login
				//フォーム認証設定
				.loginProcessingUrl("/login")
				//ユーザー名パスワード送信先URL
				.loginPage("/login")
				//ログイン画面URL
				.defaultSuccessUrl("/employee")
				//ログイン成功後リダイレクトURL
				.failureUrl("/login?error")
				//ログイン失敗後リダイレクトURL
				.permitAll()
				//ログイン画面フリーアクセス化
				
				).logout(logout -> logout
					//ログアウト設定
					.logoutSuccessUrl("/")
					//ログアウト後リダイレクトURL
					
				).authorizeHttpRequests(authz -> authz
						//URLごとに権限での認証
						.requestMatchers("/", "/customer/**","/save","/error/**","customer/check","/login").permitAll()
					.anyRequest().authenticated()
						//その他はログイン後フリー
						);
		
		
		
		
		
		return http.build();
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    

}
