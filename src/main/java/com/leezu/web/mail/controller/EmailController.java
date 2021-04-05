package com.leezu.web.mail.controller;

import java.util.Random;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leezu.web.mail.service.EmailService;

@Controller
@EnableAsync
public class EmailController {

	@Autowired
	private EmailService mailService;
	
	@GetMapping("/email/{email:.+}")
	@ResponseBody
	public String checkEmail(@PathVariable String email) {
		System.out.println("email 전송 시작 to " + email);
		
		// 이메일 중복 체크후 코드 전송 진행

		Random random = new Random();
		int num = random.nextInt(888888) + 111111;

		String setFrom = "쇼핑몰 <shoppingmall@naver.com>";
		String toMail = email;
		String title = "쇼핑몰 회원가입 인증 이메일 입니다.";
		String content = "인증 번호는 " + num + "입니다.";

		try {
			mailService.sendMessage(setFrom, toMail, title, content);
			System.out.println("인증 메일 발송");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Integer.toString(num);
	}

	
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);	// 기본 스레드 수
		executor.setMaxPoolSize(5);		// 최대 스레드 수 
		executor.setQueueCapacity(10);	// Queue 사이즈
		executor.initialize();
		return executor;
	}
}
