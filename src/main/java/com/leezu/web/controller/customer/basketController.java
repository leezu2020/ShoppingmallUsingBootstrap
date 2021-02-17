package com.leezu.web.controller.customer;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.basket.entity.Basket;
import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.product.service.IProductService;
import com.leezu.web.user.entity.AuthInfo;

@Controller
@RequestMapping("/customer/")
public class basketController {

	@Autowired
	private IBasketService basketService;
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping("basketList")
	public String basketList(Model model, HttpSession session) {
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		int sum = 0;
		for(Basket b : basketService.basketList(user.getUserID())) {
			sum += b.getTotal();
		}
		
		model.addAttribute("basketList", basketService.basketList(user.getUserID()));
		model.addAttribute("sum", sum);
		return "customer.user.basket.basketList";
	}
	
	@PostMapping("addBasket")
	public String addBasket(HttpSession session, String cnt, String productID) {
		System.out.println("cnt : " + cnt + " productID : " + productID);
		
		// 로그인 정보와 입력받은 수량, 상품id 저장 
		Basket prebasket = new Basket();
		int productid = Integer.parseInt(productID);
		prebasket.setProductID(productid);
		
		AuthInfo user = (AuthInfo) session.getAttribute("authInfo");
		prebasket.setUserID(user.getUserID());
		
		int ea = Integer.parseInt(cnt);
		prebasket.setCount(ea);
		
		
		// 장바구니에 이미 등록된 상품인지 확인
		HashMap<String, String> check = new HashMap<String, String>();
		check.put("productID", productID);
		check.put("userID", user.getUserID());
		
		int existcount = basketService.getBasketCount(check);
		if( existcount > 0) {
			System.out.println("장바구니에 이미 등록되어 있는 상품입니다.");
			
			// 등록되었다면 갯수가 재고 수량을 넘었는지 확인
			if(ea + existcount > productService.get(productid).getEa()) {
				System.out.println("재고수량을 초과했습니다.");
				return "redirect:productDetail?id="+productID;
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
