package com.example.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
@Data
public class CustomUserDetails implements UserDetails {

	private Integer userId;
	private String email;
	private String password;
	private Integer role;
	private String username;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public String getEmail() {
		// TODO 自動生成されたメソッド・スタブ
		return email;
	}
	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return password;
	}
	
	public Integer getRole() {
		// TODO 自動生成されたメソッド・スタブ
		return role;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return username;
	}
}
