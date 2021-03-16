package com.leezu.web.order.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.basket.entity.Basket;
import com.leezu.web.basket.service.IBasketService;
import com.leezu.web.notice.entity.PrivateNotice;
import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.order.entity.Order;
import com.leezu.web.order.service.IOrderService;
import com.leezu.web.product.service.IProductService;

@Controller
@RequestMapping("/customer/user/")
public class CustomerOrderController {
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IBasketService basketService;
	
	@Autowired
	private INoticeService noticeService;
	
	// 주문 목록 가져오기
	@GetMapping("orders")
	public String orderList(Model model, Principal user) {
		String userID = user.getName();
		
		List<Order> orderList = orderService.getOrderList(userID);
		double totalPrice = 0;
		for(Order o : orderList) {
			totalPrice += o.getTotal();
		}
		
		// 개인 공지사항 가져오기
		List<PrivateNotice> notices = noticeService.getPrivateOrderNotice(userID);
		model.addAttribute("noticeList", notices);
		
		model.addAttribute("orderList", orderList);
		model.addAttribute("totalPrice", totalPrice);
		return "customer.user.order.orderList";
	}
	
	// 체크된 목록 불러오기
	@GetMapping("order")
	public String order(Model model, HttpServletRequest request) {
		
		String[] basketChecked = request.getParameterValues("basketChecked");
		int[] basketIDs = Arrays.stream(basketChecked).mapToInt(Integer::parseInt).toArray();
		List<Basket> products = basketService.getBasketByIds(basketIDs);
		
		int sum = 0;
		
		for(Basket b : products) {
			sum += b.getTotal();
		}
		
		model.addAttribute("products", products);
		model.addAttribute("sum", sum);
		
		return "customer.user.order.order";
	}
	
	@PostMapping("order")
	public String order(Model model, Principal user,
			Integer[] productID, String[] userID, Integer[] count, Double[] total, Integer[] basketID,
			Order order, String address1, String address2) {

		String pattern = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		
		for(int i=0; i<productID.length; i++) {
			Order ordering = new Order();
			ordering.setAddress(address1 + address2);
			ordering.setCount(count[i]);
			ordering.setTotal(total[i]);
			ordering.setProductID(productID[i]);
			ordering.setUserID(userID[i]);
			ordering.setZipcode(order.getZipcode());

			// 주문번호 설정
			int cnt = orderService.getCount() % 1000000;
			String orderID = date + "-" + String.format("%06d",cnt);
			ordering.setOrderID(orderID);
			
			
			// 주문 완료시 order entity로 insert 진행
			orderService.addOrder(ordering);
			
			// 주문 완료시 basketID로 basket 삭제 진행
			basketService.delBasketById(basketID[i]);
			
			// 주문 완료시 재고 수량 수정
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("productID", productID[i]);
			map.put("count", count[i]);
			productService.modProductCnt(map);
		}
		
		
		model.addAttribute("orderList", orderService.getOrderList(user.getName()));
		return "customer.user.order.orderList";
	}
}
