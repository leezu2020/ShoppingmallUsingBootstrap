package com.leezu.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/")
public class EventController {


	@RequestMapping("eventList")
	public String eventList() {
		return "customer.event.eventList";
	}
	
	@RequestMapping("eventDetail")
	public String eventDetail() {
		return "customer.event.eventDetail";
	}
}
