package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.domain.user.model.MPlace;
import com.example.domain.user.model.MUser;
import com.example.domain.user.model.MWork;

@Mapper
public interface UserMapper {
	
	//ログインユーザー取得
	public MUser findLoginUser(String email);
	
	//ユーザー新規登録
	public int insertOne(MUser user);
	
	//勤務情報登録
	public int insertWorkInfo(MWork work);
	
	//勤務地登録
	public int insertWorkPlace(MPlace place);
	
	//パスワード変更
	public void updatePassword(@Param("userId") Integer userId, @Param("password") String password);
	
	//ログインユーザーの年月日取得
	public List<MWork> findYearMonth(Integer userId);
	
	//該当月の勤務日取得
	public List<MWork> selectWorkInfoWithPlace(Integer userId, String workDay);
}
