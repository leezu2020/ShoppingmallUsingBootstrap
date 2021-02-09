package com.leezu.web.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leezu.web.notice.service.INoticeService;
import com.leezu.web.paging.DAO.PagingDAO;

@Controller
@RequestMapping("/customer/")
public class NoticeController {

	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping("noticeList")
	public String noticeList(Model model, PagingDAO paging,
			@RequestParam(defaultValue = "1")int nowPage,
			@RequestParam(defaultValue = "5")int cntPerPage) throws Exception {
		
		
		int userNum = noticeService.getNoticeNum();
		
		paging = new PagingDAO(userNum, nowPage, cntPerPage);
		
		model.addAttribute("noticeList", noticeService.getList(paging));
		model.addAttribute("page", paging);
		return "customer.notice.noticeList";
	}
	
	@RequestMapping("noticeDetail")
	public String noticedetail(Model model, int id) throws Exception{
		model.addAttribute("notice", noticeService.getNotice(id));
		return "customer.notice.noticeDetail";
	}
	
}
