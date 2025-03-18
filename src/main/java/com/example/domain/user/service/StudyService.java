package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;
import com.example.domain.user.model.MWork;


public interface StudyService {
	//ログインユーザー取得
	public MUser findLoginUser(String email);
	/* ユーザー新規登録 */
	public void insertOne(MUser user);
	/* パスワード変更 */
	public void updatePassword(Integer userId, String password);
	//ログインユーザーの年月日取得
	public List<MWork> findYearMonth(Integer userId);
	//該当月の勤務日取得
	public List<MWork> selectWorkInfoWithPlace(Integer userId, String workDay);
}
