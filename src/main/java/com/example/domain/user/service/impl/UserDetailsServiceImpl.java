package com.example.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.config.CustomUserDetails;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.StudyService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private StudyService service;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		//ユーザー情報取得
		MUser loginUser = service.findLoginUser(email);
		
		//ユーザーがいない場合
		if(loginUser == null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		//UserDetails作成
		CustomUserDetails userDetails = new CustomUserDetails();
		
		userDetails.setEmail(loginUser.getEmail());
		userDetails.setPassword(loginUser.getPassword());
		userDetails.setRole(loginUser.getRole());
		userDetails.setUserId(loginUser.getUserId());
		
		return userDetails;
	}

}
