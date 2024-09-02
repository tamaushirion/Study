package com.example.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.StudyService;
import com.example.repository.UserMapper;

@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//ログインユーザー取得
	@Override
	public MUser findLoginUser(String email) {
		return userMapper.findLoginUser(email);
	}
	//ユーザー新規登録
	@Override
	public void insertOne(MUser user) {
		String rawPassword = user.getPassword();
		user.setPassword(passwordEncoder.encode(rawPassword));
		user.setRole(1);
		userMapper.insertOne(user);
	}
	//パスワード変更
	@Override
	public void updatePassword(Integer userId, String password) {
		userMapper.updatePassword(userId, passwordEncoder.encode(password));
	}
}
