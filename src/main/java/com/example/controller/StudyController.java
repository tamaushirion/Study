package com.example.controller;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.config.CustomUserDetails;
import com.example.domain.user.model.MUser;
import com.example.domain.user.model.MWork;
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

	//js勉強
	@GetMapping("js")
	public String getJs() {
		return "js/js";
	}
	
	
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
	public String getHome(Model model, @AuthenticationPrincipal CustomUserDetails user) {
		
		List<String> yearMonth = new ArrayList<>();
		
		List<MWork> findYearMonth = service.findYearMonth(user.getUserId());
		String lastMonth = "0000-00-00";
		for(MWork date: findYearMonth) {
			String sdate = String.valueOf(date.getWorkDay());
			
			if(sdate.substring(5,7).equals(lastMonth.substring(5, 7)) && sdate.substring(2,4).equals(lastMonth.substring(2, 4))) {
				lastMonth = sdate;
				continue;
			}
			lastMonth = sdate;
			
			yearMonth.add(sdate.substring(0,7));
		}
		
		model.addAttribute("yearMonth", yearMonth);
		
		return "user/home";
	}
	
	/* 該当月勤務情報 */
	@GetMapping("WorkInformation/{YearMonth}")
	public String getWorkInformation(Model model, @PathVariable("YearMonth") String YearMonth, @AuthenticationPrincipal CustomUserDetails user) throws ParseException {
		
		List<MWork> relevantMonth = service.selectWorkInfoWithPlace(user.getUserId(), YearMonth);//DBから取得した勤務日
		List<MWork> relevantMonthList = new ArrayList<>();//結果格納よう
		
		// フォーマット
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// 月初
		LocalDate ldFirst = LocalDate.parse(YearMonth + "-01", dtf).withDayOfMonth(1);
		// 月末
		LocalDate ldLast = LocalDate.parse(YearMonth + "-01", dtf).withDayOfMonth(1).plusMonths(1).minusDays(1);
		
		int days = ldLast.getDayOfMonth();
		LocalDate countDays = ldFirst;
		
		for(int i = 0; i < days; i++) {
			
			
			for(MWork month : relevantMonth) {
				if(0 == month.getWorkDay().compareTo(Date.valueOf(countDays))) {
					relevantMonthList.add(month);
					countDays = countDays.plusDays(1);
					continue;
				} else {
					MWork day = new MWork();
					day.setWorkDay(Date.valueOf(countDays));
					
					relevantMonthList.add(day);
					countDays = countDays.plusDays(1);
					break;
				}
				
			}
		}
		
		
		model.addAttribute("relevantMonthList", relevantMonthList);
		
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
