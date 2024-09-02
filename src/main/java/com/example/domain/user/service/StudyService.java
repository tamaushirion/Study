package com.example.domain.user.service;

import com.example.domain.user.model.MUser;


public interface StudyService {
	//ログインユーザー取得
	public MUser findLoginUser(String email);
	/* ユーザー新規登録 */
	public void insertOne(MUser user);
	/* パスワード変更 */
	public void updatePassword(Integer userId, String password);
}
