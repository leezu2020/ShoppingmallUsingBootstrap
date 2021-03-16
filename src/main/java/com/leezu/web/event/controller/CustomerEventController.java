package com.leezu.web.event.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/")
public class CustomerEventController {


	@RequestMapping("events")
	public String eventList() {
		return "customer.event.eventList";
	}
	
	@RequestMapping("event/{id}")
	public String eventDetail(@PathVariable int id) {
		return "customer.event.eventDetail";
	}
}
