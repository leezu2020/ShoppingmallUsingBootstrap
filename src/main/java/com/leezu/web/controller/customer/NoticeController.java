package com.leezu.web.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.notice.service.INoticeService;

@Controller
@RequestMapping("/customer/")
public class NoticeController {

	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping("noticelist")
	public String noticelist(Model model) throws Exception{
		model.addAttribute("noticeList", noticeService.getList());
		return "customer.notice.noticeList";
	}
	
	@RequestMapping("noticeDetail")
	public String noticedetail(Model model) throws Exception{
		model.addAttribute("notice", noticeService.getNotice(1));
		return "customer.notice.noticeDetail";
	}
	
}
