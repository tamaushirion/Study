package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudyController {

	/* ログイン画面 */
	@GetMapping("login")
	public String getLogin() {
		return "login/login";
	}
	
	/* ユーザー新規登録 */
	@GetMapping("signup")
	public String getSignup() {
		return "user/signup";
	}
	
	@PostMapping("signup")
	public String postSignup() {
		return "redirect:/login";
	}
	
	/* ホーム画面 */
	@GetMapping("home")
	public String getHome() {
		return "user/home";
	}
	
	/* 該当月勤務情報 */
	@GetMapping("WorkInformation")
	public String getWorkInformation() {
		return "user/workInformation";
	}
	
	/* パスワード変更画面 */
	@GetMapping("password")
	public String getPassword() {
		return "user/password";
	}
	
	@PostMapping("password")
	public String postPassword() {
		return "redirect:/home";
	}
	
	/* 勤務情報登録画面 */
	@GetMapping("WorkRegistration")
	public String getWorkRegistration() {
		return "user/workRegistration";
	}
	
	@PostMapping("WorkRegistration")
	public String postWorkRegistration() {
		return "redirect:/home";
	}
	
	/* 勤務情報一覧画面 */
	@GetMapping("WorkList")
	public String getWorkList() {
		return "user/workList";
	}
	
	@PostMapping
	public String postWorkList() {
		return "redirect:/home";
	}
}
