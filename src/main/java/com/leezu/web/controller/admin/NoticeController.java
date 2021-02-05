package com.leezu.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.notice.service.INoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/")
public class NoticeController {
	
	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping("noticeList")
	public String noticeList(Model model) throws Exception {
		model.addAttribute("noticeList", noticeService.getList());
		return "admin.notice.noticeList";
	}
	
	@GetMapping("regNotice")
	public String regNotice() {
		return "admin.notice.regNotice";
	}
	
	@PostMapping("regNotice")
	public String regNotice(preNotice notice) throws Exception {
		noticeService.regNotice(notice);
		return "redirect:noticeList";
	}
}
