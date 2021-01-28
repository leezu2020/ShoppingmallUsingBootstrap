package com.leezu.web.controller.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.leezu.web.user.DTO.UserRegReq;

public class UserRegValidator implements Validator{

	private static final String emailRegExp = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
	private Pattern pattern;
	
	public UserRegValidator() {
		// TODO Auto-generated constructor stub
		pattern = Pattern.compile(emailRegExp);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("유효성검사 시작 UserRegValidator");
		// TODO Auto-generated method stub
		UserRegReq regReq = (UserRegReq) target;
		
		if(regReq.getUserID() == null || regReq.getUserID().trim().isEmpty()) {
			errors.rejectValue("userID", "required", "아이디를 입력해주세요.");
		}
		
		if(regReq.getUserEmail() == null || regReq.getUserEmail().trim().isEmpty()) {
			errors.rejectValue("userEmail", "required", "이메일을 입력해주세요.");
		} else {
			Matcher matcher = pattern.matcher(regReq.getUserEmail());
			if(!matcher.matches()) {
				errors.rejectValue("userEmail", "bad", "올바르지 않는 형식입니다.");
			}
		}
		ValidationUtils.rejectIfEmpty(errors, "userPassword", "required", "비밀번호를 입력해주세요.");
		ValidationUtils.rejectIfEmpty(errors, "checkPassword", "required", "비밀번호 확인을 해주세요.");
		if(!regReq.getUserPassword().isEmpty()) {
			if(!regReq.isPwEqual()) {
				errors.rejectValue("checkPassword", "nomatch", "비밀번호가 일치하지 않습니다.");
			}
		}
		System.out.println("유효성검사 끝 UserRegValidator");
	}

}
