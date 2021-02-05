package com.leezu.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/")
public class EventController {

	@RequestMapping("/event1")
	public String event1() {
		System.out.println("event페이지 맵핑");
		return "customer.event.event1";
	}
	@RequestMapping("/event2")
	public String event2() {
		System.out.println("event페이지 맵핑");
		return "customer.event.event2";
	}
	@RequestMapping("/event3")
	public String event3() {
		System.out.println("event페이지 맵핑");
		return "customer.event.event3";
	}
}
