package com.leezu.web.basket.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.basket.entity.Basket;
import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.notice.entity.PrivateNotice;
import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/customer/user/")
public class basketController {

	@Autowired
	private IBasketService basketService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping("basketList")
	public String basketList(Model model, Principal user) {
		// 유저 아이디 가져오기
		String userID = user.getName();
		
		double sum = 0;
		for(Basket b : basketService.basketList(userID)) {
			sum += b.getTotal();
		}
		
		model.addAttribute("basketList", basketService.basketList(userID));
		model.addAttribute("sum", sum);
		
		// 개인 공지사항 가져오기
		List<PrivateNotice> notices = noticeService.getPrivateNotice(userID);
		model.addAttribute("noticeList", notices);
		
		return "customer.user.basket.basketList";
		
	}
	
	@PostMapping("addBasket")
	public String addBasket(Principal user, int cnt, String productID) {
		System.out.println("cnt : " + cnt + " productID : " + productID);
		
		// 로그인 정보와 입력받은 수량, 상품id 저장 
		Basket prebasket = new Basket();
		int productid = Integer.parseInt(productID);
		prebasket.setProductID(productid);
		
		// 유저 아이디 가져오기
		String userID = user.getName();
		prebasket.setUserID(userID);
		
		prebasket.setCount(cnt);
		
		
		// 장바구니에 이미 등록된 상품인지 확인
		HashMap<String, String> check = new HashMap<String, String>();
		check.put("productID", productID);
		check.put("userID", userID);
		
		Integer existcount = basketService.getBasketCount(check);
		if( existcount != null) {
			System.out.println("장바구니에 이미 등록되어 있는 상품입니다.");
			
			// 등록되었다면 갯수가 재고 수량을 넘었는지 확인
			if(cnt + existcount > productService.get(productid).getEa()) {
				System.out.println("재고수량을 초과했습니다.");
				return "redirect:/customer/productDetail?id="+productID;
			}
			else {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("basket", prebasket);
				
				basketService.modBasket(map);
				return "redirect:basketList";
			}
			
		}
		// 장바구니에 등록 
		else {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("basket", prebasket);
			
			basketService.addBasket(map);
			return "redirect:basketList";
		}
	}
}
