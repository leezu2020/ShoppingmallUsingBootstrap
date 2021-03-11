package com.leezu.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/")
public class EventController {


	@RequestMapping("events")
	public String eventList() {
		return "customer.event.eventList";
	}
	
	@RequestMapping("event/{id}")
	public String eventDetail(@PathVariable int id) {
		return "customer.event.eventDetail";
	}
}
