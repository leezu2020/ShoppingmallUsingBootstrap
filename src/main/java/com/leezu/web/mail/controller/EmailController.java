package com.leezu.web.mail.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leezu.web.mail.service.MailService;

@Controller
@EnableAsync
public class EmailController {

	@Autowired
	private MailService mailService;
	
	@ResponseBody
	@GetMapping("/email/{email:.+}")
	public String checkEmail(@PathVariable("email") String email) {
		
		
		System.out.println("email은 " + email);
		
		Random random = new Random();
		int num = random.nextInt(888888) + 111111;
		
		String setFrom = "bookpot@bookpot.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "인증 번호는 " + num + "입니다.";
		
		
		try {
			mailService.sendMessage(setFrom, toMail, title, content);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Integer.toString(num);
	}
}
