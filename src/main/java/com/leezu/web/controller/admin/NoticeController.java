package com.leezu.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leezu.web.notice.entity.preNotice;
import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.paging.DAO.PagingDAO;

@Controller("adminNoticeController")
@RequestMapping("/admin/")
public class NoticeController {
	
	@Autowired
	private INoticeService noticeService;
	
	@GetMapping("noticeList")
	public String noticeList(Model model, PagingDAO paging,
			@RequestParam(defaultValue = "1")int nowPage,
			@RequestParam(defaultValue = "5")int cntPerPage) throws Exception {
		
		
		int userNum = noticeService.getNoticeNum();
		
		paging = new PagingDAO(userNum, nowPage, cntPerPage);
		
		model.addAttribute("noticeList", noticeService.getList(paging));
		model.addAttribute("page", paging);
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
