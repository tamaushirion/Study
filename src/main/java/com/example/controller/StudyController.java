package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.config.CustomUserDetails;
import com.example.domain.user.model.MUser;
import com.example.domain.user.service.impl.StudyServiceImpl;
import com.example.form.PasswordForm;
import com.example.form.SignupForm;
import com.example.form.WorkInfoForm;

@Controller
public class StudyController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private StudyServiceImpl service;
	@Autowired
	private ModelMapper modelmapper;

	/* ログイン画面 */
	@GetMapping("login")
	public String getLogin() {
		return "login/login";
	}
	
	/* ユーザー新規登録 */
	@GetMapping("signup")
	public String getSignup(@ModelAttribute @Validated SignupForm form, Model model) {
		return "user/signup";
	}
	
	@PostMapping("signup")
	public String postSignup(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return getSignup(form, model);
		}
		
		MUser user = modelmapper.map(form, MUser.class);
		service.insertOne(user);
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
	public String getPassword(PasswordForm form, Model model) {
		return "user/password";
	}
	
	@PostMapping(value = "password", params = "update")
	public String postPassword(@Validated PasswordForm form, BindingResult bindingResult, Model model, @AuthenticationPrincipal CustomUserDetails user) {
		if(passwordEncoder.matches(form.getOldPassword(), user.getPassword())) {
			
			service.updatePassword(user.getUserId(), form.getNewPassword());
		}
		
		return "redirect:/home";
	}
	
	/* 勤務情報登録画面 */
	@GetMapping("WorkRegistration")
	public String getWorkRegistration(@ModelAttribute WorkInfoForm form, Model model) {
		form.setWorkPlace("水戸市");
		
		return "user/workRegistration";
	}
	
	@PostMapping("WorkRegistration")
	public String postWorkRegistration(@ModelAttribute @Validated WorkInfoForm form, BindingResult bindingResult, Model model, @AuthenticationPrincipal CustomUserDetails user) {
		
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
