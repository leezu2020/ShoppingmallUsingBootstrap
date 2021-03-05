package com.leezu.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.leezu.web.product.entity.Product;

public class ProductRegValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("상품 등록 유효성검사 시작");
		// TODO Auto-generated method stub
		Product product = (Product) target;
		
		if(product.getPrice() > Integer.MAX_VALUE || product.getPrice() < 0) {
			errors.rejectValue("productprice", "overflow", "올바른 금액을 입력해주세요.");
		}
		if(product.getEa() > Integer.MAX_VALUE || product.getEa() <= 0) {
			errors.rejectValue("productprice", "overflow", "올바른 재고 수량을 입력해주세요.");
		}
		ValidationUtils.rejectIfEmpty(errors, "productPrice", "required", "금액을 입력해주세요.");
		ValidationUtils.rejectIfEmpty(errors, "productEa", "required", "재고 수량을 입력해주세요.");
		
		System.out.println("상품 등록 유효성검사 끝");
	}

}
