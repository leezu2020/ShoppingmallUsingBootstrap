package com.leezu.web.mail.service;

import java.util.concurrent.Executor;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;

	@Async
	public void sendMessage(String setFrom, String toMail, String title, String content) throws MessagingException {

		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
		helper.setFrom(setFrom);
		helper.setTo(toMail);
		helper.setSubject(title);
		helper.setText(content, true);

		mailSender.send(msg);
	}
	
	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(1);
		executor.setQueueCapacity(50);
		executor.initialize();
		return executor;
	}
}
